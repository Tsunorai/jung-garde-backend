package ch.junggarde.api.adapter.out.codec;

import ch.junggarde.api.model.GalleryImage;
import ch.junggarde.api.model.Image;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

@SuppressWarnings("ALL")
public class DBCodecProvider implements CodecProvider {
    @Override
    public <T> Codec<T> get(final Class<T> clazz, final CodecRegistry registry) {
        if (clazz.equals(Image.class)) {
            return (Codec<T>) new ImageCodec();
        } else if (clazz.equals(GalleryImage.class)) {
            return (Codec<T>) new GalleryImageCodec();
        }
        return null;
    }
}
