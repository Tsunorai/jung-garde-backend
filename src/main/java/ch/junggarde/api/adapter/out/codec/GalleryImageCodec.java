package ch.junggarde.api.adapter.out.codec;

import ch.junggarde.api.model.GalleryImage;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.time.Year;
import java.util.UUID;

public class GalleryImageCodec implements CollectibleCodec<GalleryImage> {
    private final Codec<Document> documentCodec;

    public GalleryImageCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public GalleryImage decode(BsonReader bsonReader, DecoderContext decoderContext) {
        final Document document = documentCodec.decode(bsonReader, decoderContext);

        return new GalleryImage(
                UUID.fromString(document.getString(GalleryImage.Fields.id)),
                UUID.fromString(document.getString("imageId")),
                Year.parse(document.getString(GalleryImage.Fields.year)),
                document.getString(GalleryImage.Fields.event),
                UUID.fromString(document.getString(GalleryImage.Fields.positionId))
        );
    }

    @Override
    public void encode(BsonWriter bsonWriter, GalleryImage galleryImage, EncoderContext encoderContext) {
        final Document document = new Document()
                .append(GalleryImage.Fields.id, galleryImage.getId())
                .append("imageId", galleryImage.getImageId().toString())
                .append(GalleryImage.Fields.year, galleryImage.getYear())
                .append(GalleryImage.Fields.event, galleryImage.getEvent())
                .append(GalleryImage.Fields.positionId, galleryImage.getPositionId());

        documentCodec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<GalleryImage> getEncoderClass() {
        return GalleryImage.class;
    }

    @Override
    public GalleryImage generateIdIfAbsentFromDocument(GalleryImage galleryImage) {
        return galleryImage;
    }

    @Override
    public boolean documentHasId(GalleryImage galleryImage) {
        return true;
    }

    @Override
    public BsonValue getDocumentId(GalleryImage galleryImage) {
        return new BsonString(galleryImage.getId().toString());
    }
}
