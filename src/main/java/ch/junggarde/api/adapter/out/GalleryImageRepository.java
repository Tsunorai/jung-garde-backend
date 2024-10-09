package ch.junggarde.api.adapter.out;

import ch.junggarde.api.model.GalleryImage;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GalleryImageRepository {
    private static final String COLLECTION = "galleryImage";

    @Inject
    Instance<MongoClient> mongoClient;

    @ConfigProperty(name = "quarkus.mongodb.database")
    String database;

    private MongoCollection<GalleryImage> collection() {
        return mongoClient.get().getDatabase(database).getCollection(COLLECTION, GalleryImage.class);
    }

    public void save(GalleryImage galleryImage) {
        collection().insertOne(galleryImage);
    }

    public List<GalleryImage> getGallery() {
        return collection().find().into(new ArrayList<GalleryImage>());
    }
}
