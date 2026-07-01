package b.o.a.o;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.o.c, reason: use source file name */
/* JADX INFO: compiled from: NoFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NoFilter extends BaseFilter {
    @Override // b.o.a.o.Filter2
    @NonNull
    public String h() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    }
}
