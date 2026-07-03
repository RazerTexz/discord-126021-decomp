package p007b.p222h.p223a.p224a;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: renamed from: b.h.a.a.b */
/* JADX INFO: compiled from: AndroidXBlurImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2399b implements InterfaceC2400c {

    /* JADX INFO: renamed from: a */
    public static Boolean f5104a;

    /* JADX INFO: renamed from: b */
    public RenderScript f5105b;

    /* JADX INFO: renamed from: c */
    public ScriptIntrinsicBlur f5106c;

    /* JADX INFO: renamed from: d */
    public Allocation f5107d;

    /* JADX INFO: renamed from: e */
    public Allocation f5108e;

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    /* JADX INFO: renamed from: a */
    public void mo2284a(Bitmap bitmap, Bitmap bitmap2) {
        this.f5107d.copyFrom(bitmap);
        this.f5106c.setInput(this.f5107d);
        this.f5106c.forEach(this.f5108e);
        this.f5108e.copyTo(bitmap2);
    }

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    /* JADX INFO: renamed from: b */
    public boolean mo2285b(Context context, Bitmap bitmap, float f) {
        if (this.f5105b == null) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                this.f5105b = renderScriptCreate;
                this.f5106c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (RSRuntimeException e) {
                if (f5104a == null && context != null) {
                    f5104a = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
                }
                if (f5104a == Boolean.TRUE) {
                    throw e;
                }
                release();
                return false;
            }
        }
        this.f5106c.setRadius(f);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f5105b, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f5107d = allocationCreateFromBitmap;
        this.f5108e = Allocation.createTyped(this.f5105b, allocationCreateFromBitmap.getType());
        return true;
    }

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    public void release() {
        Allocation allocation = this.f5107d;
        if (allocation != null) {
            allocation.destroy();
            this.f5107d = null;
        }
        Allocation allocation2 = this.f5108e;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f5108e = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f5106c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f5106c = null;
        }
        RenderScript renderScript = this.f5105b;
        if (renderScript != null) {
            renderScript.destroy();
            this.f5105b = null;
        }
    }
}
