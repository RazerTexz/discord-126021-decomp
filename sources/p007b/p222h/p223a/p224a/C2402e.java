package p007b.p222h.p223a.p224a;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: renamed from: b.h.a.a.e */
/* JADX INFO: compiled from: SupportLibraryBlurImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2402e implements InterfaceC2400c {

    /* JADX INFO: renamed from: a */
    public static Boolean f5109a;

    /* JADX INFO: renamed from: b */
    public RenderScript f5110b;

    /* JADX INFO: renamed from: c */
    public ScriptIntrinsicBlur f5111c;

    /* JADX INFO: renamed from: d */
    public Allocation f5112d;

    /* JADX INFO: renamed from: e */
    public Allocation f5113e;

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    /* JADX INFO: renamed from: a */
    public void mo2284a(Bitmap bitmap, Bitmap bitmap2) {
        this.f5112d.copyFrom(bitmap);
        this.f5111c.setInput(this.f5112d);
        this.f5111c.forEach(this.f5113e);
        this.f5113e.copyTo(bitmap2);
    }

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    /* JADX INFO: renamed from: b */
    public boolean mo2285b(Context context, Bitmap bitmap, float f) {
        if (this.f5110b == null) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                this.f5110b = renderScriptCreate;
                this.f5111c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (RSRuntimeException e) {
                if (f5109a == null && context != null) {
                    f5109a = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
                }
                if (f5109a == Boolean.TRUE) {
                    throw e;
                }
                release();
                return false;
            }
        }
        this.f5111c.setRadius(f);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f5110b, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f5112d = allocationCreateFromBitmap;
        this.f5113e = Allocation.createTyped(this.f5110b, allocationCreateFromBitmap.getType());
        return true;
    }

    @Override // p007b.p222h.p223a.p224a.InterfaceC2400c
    public void release() {
        Allocation allocation = this.f5112d;
        if (allocation != null) {
            allocation.destroy();
            this.f5112d = null;
        }
        Allocation allocation2 = this.f5113e;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f5113e = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f5111c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f5111c = null;
        }
        RenderScript renderScript = this.f5110b;
        if (renderScript != null) {
            renderScript.destroy();
            this.f5110b = null;
        }
    }
}
