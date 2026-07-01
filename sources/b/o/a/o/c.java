package b.o.a.o;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: NoFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    @Override // b.o.a.o.b
    @NonNull
    public String h() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    }
}
