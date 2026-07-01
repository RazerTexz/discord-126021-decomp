package d0.e0.p.d.m0.j;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a {
    public static boolean getIncludeAnnotationArguments(h hVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "this");
        return hVar.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
    }

    public static boolean getIncludeEmptyAnnotationArguments(h hVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "this");
        return hVar.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
    }
}
