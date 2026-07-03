package p007b.p222h.p223a.p224a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: renamed from: b.h.a.a.a */
/* JADX INFO: compiled from: AndroidStockBlurImpl.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(17)
public class C2398a implements InterfaceC2400c {

    /* JADX INFO: renamed from: a */
    public static Boolean f5099a;

    /* JADX INFO: renamed from: b */
    public RenderScript f5100b;

    /* JADX INFO: renamed from: c */
    public ScriptIntrinsicBlur f5101c;

    /* JADX INFO: renamed from: d */
    public Allocation f5102d;

    /* JADX INFO: renamed from: e */
    public Allocation f5103e;

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    /* JADX INFO: renamed from: a */
    public void mo2284a(Bitmap bitmap, Bitmap bitmap2) {
        this.f5102d.copyFrom(bitmap);
        this.f5101c.setInput(this.f5102d);
        this.f5101c.forEach(this.f5103e);
        this.f5103e.copyTo(bitmap2);
    }

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    /* JADX INFO: renamed from: b */
    public boolean mo2285b(Context context, Bitmap bitmap, float f) {
        if (this.f5100b == null) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                this.f5100b = renderScriptCreate;
                this.f5101c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (RSRuntimeException e) {
                if (f5099a == null && context != null) {
                    f5099a = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
                }
                if (f5099a == Boolean.TRUE) {
                    throw e;
                }
                release();
                return false;
            }
        }
        this.f5101c.setRadius(f);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f5100b, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f5102d = allocationCreateFromBitmap;
        this.f5103e = Allocation.createTyped(this.f5100b, allocationCreateFromBitmap.getType());
        return true;
    }

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    public void release() {
        Allocation allocation = this.f5102d;
        if (allocation != null) {
            allocation.destroy();
            this.f5102d = null;
        }
        Allocation allocation2 = this.f5103e;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f5103e = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f5101c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f5101c = null;
        }
        RenderScript renderScript = this.f5100b;
        if (renderScript != null) {
            renderScript.destroy();
            this.f5100b = null;
        }
    }
}
