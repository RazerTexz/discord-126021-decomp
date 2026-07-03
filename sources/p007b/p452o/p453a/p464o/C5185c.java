package p007b.p452o.p453a.p464o;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.o.c */
/* JADX INFO: compiled from: NoFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5185c extends AbstractC5183a {
    @Override // p007b.p452o.p453a.p464o.InterfaceC5184b
    @NonNull
    /* JADX INFO: renamed from: h */
    public String mo7375h() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    }
}
