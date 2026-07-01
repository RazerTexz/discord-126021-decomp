package b.h.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Allocation$MipmapControl;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: compiled from: SupportLibraryBlurImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements c {
    public static Boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RenderScript f741b;
    public ScriptIntrinsicBlur c;
    public Allocation d;
    public Allocation e;

    @Override // b.h.a.a.c
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.d.copyFrom(bitmap);
        this.c.setInput(this.d);
        this.c.forEach(this.e);
        this.e.copyTo(bitmap2);
    }

    @Override // b.h.a.a.c
    public boolean b(Context context, Bitmap bitmap, float f) {
        if (this.f741b == null) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                this.f741b = renderScriptCreate;
                this.c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (RSRuntimeException e) {
                if (a == null && context != null) {
                    a = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
                }
                if (a == Boolean.TRUE) {
                    throw e;
                }
                release();
                return false;
            }
        }
        this.c.setRadius(f);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f741b, bitmap, Allocation$MipmapControl.MIPMAP_NONE, 1);
        this.d = allocationCreateFromBitmap;
        this.e = Allocation.createTyped(this.f741b, allocationCreateFromBitmap.getType());
        return true;
    }

    @Override // b.h.a.a.c
    public void release() {
        Allocation allocation = this.d;
        if (allocation != null) {
            allocation.destroy();
            this.d = null;
        }
        Allocation allocation2 = this.e;
        if (allocation2 != null) {
            allocation2.destroy();
            this.e = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.c = null;
        }
        RenderScript renderScript = this.f741b;
        if (renderScript != null) {
            renderScript.destroy();
            this.f741b = null;
        }
    }
}
