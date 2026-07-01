package b.f.j.p;

import b.f.j.d.Priority2;
import b.f.j.e.ImagePipelineConfigInterface;
import b.f.j.j.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

/* JADX INFO: renamed from: b.f.j.p.x0, reason: use source file name */
/* JADX INFO: compiled from: ProducerContext.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ProducerContext {
    Map<String, Object> a();

    Object b();

    Priority2 c();

    <E> void d(String str, E e);

    ImageRequest e();

    void f(ProducerContextCallbacks producerContextCallbacks);

    ImagePipelineConfigInterface g();

    String getId();

    void h(EncodedImageOrigin encodedImageOrigin);

    void i(String str, String str2);

    void j(Map<String, ?> map);

    boolean k();

    <E> E l(String str);

    String m();

    void n(String str);

    ProducerListener2 o();

    boolean p();

    ImageRequest.c q();
}
