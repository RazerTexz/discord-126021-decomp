package b.f.j.p;

import b.f.j.d.Priority2;
import b.f.j.e.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: renamed from: b.f.j.p.d1, reason: use source file name */
/* JADX INFO: compiled from: SettableProducerContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ImageRequest imageRequest, ProducerContext producerContext) {
        super(imageRequest, producerContext.getId(), producerContext.m(), producerContext.o(), producerContext.b(), producerContext.q(), producerContext.k(), producerContext.p(), producerContext.c(), producerContext.g());
    }

    public SettableProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.c cVar, boolean z2, boolean z3, Priority2 priority2, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        super(imageRequest, str, str2, producerListener2, obj, cVar, z2, z3, priority2, imagePipelineConfigInterface);
    }
}
