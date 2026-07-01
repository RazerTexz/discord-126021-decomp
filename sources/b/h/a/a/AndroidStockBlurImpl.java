package b.h.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: renamed from: b.h.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: AndroidStockBlurImpl.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(17)
public class AndroidStockBlurImpl implements BlurImpl {
    public static Boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RenderScript f739b;
    public ScriptIntrinsicBlur c;
    public Allocation d;
    public Allocation e;

    @Override // b.h.a.a.BlurImpl
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.d.copyFrom(bitmap);
        this.c.setInput(this.d);
        this.c.forEach(this.e);
        this.e.copyTo(bitmap2);
    }

    @Override // b.h.a.a.BlurImpl
    public boolean b(Context context, Bitmap bitmap, float f) {
        if (this.f739b == null) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                this.f739b = renderScriptCreate;
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
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f739b, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.d = allocationCreateFromBitmap;
        this.e = Allocation.createTyped(this.f739b, allocationCreateFromBitmap.getType());
        return true;
    }

    @Override // b.h.a.a.BlurImpl
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
        RenderScript renderScript = this.f739b;
        if (renderScript != null) {
            renderScript.destroy();
            this.f739b = null;
        }
    }
}
