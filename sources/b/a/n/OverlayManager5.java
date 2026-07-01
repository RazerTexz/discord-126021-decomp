package b.a.n;

import android.view.View;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.n.d, reason: use source file name */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayManager5 implements View.OnClickListener {
    public final /* synthetic */ OverlayManager j;
    public final /* synthetic */ Function1 k;
    public final /* synthetic */ OverlayBubbleWrap l;
    public final /* synthetic */ Object m;

    /* JADX INFO: renamed from: b.a.n.d$a */
    /* JADX INFO: compiled from: OverlayManager.kt */
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b.a.n.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: View.kt */
        public static final class ViewOnLayoutChangeListenerC0015a implements View.OnLayoutChangeListener {
            public final /* synthetic */ View k;

            public ViewOnLayoutChangeListenerC0015a(View view) {
                this.k = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                Intrinsics3.checkNotNullParameter(view, "view");
                view.removeOnLayoutChangeListener(this);
                View viewFindViewWithTag = this.k.findViewWithTag(OverlayManager5.this.m);
                Intrinsics3.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
                OverlayManager5.this.l.b(viewFindViewWithTag);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics3.checkNotNullParameter(view, "v");
            if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
                view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0015a(view));
                return;
            }
            View viewFindViewWithTag = view.findViewWithTag(OverlayManager5.this.m);
            Intrinsics3.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
            OverlayManager5.this.l.b(viewFindViewWithTag);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewCompat.isAttachedToWindow(OverlayManager5.this.l)) {
                OverlayManager5.this.l.setBubbleTouchable(true);
                OverlayManager5.this.l.a(true);
            }
        }
    }

    public OverlayManager5(OverlayManager overlayManager, Function1 function1, OverlayBubbleWrap overlayBubbleWrap, Object obj) {
        this.j = overlayManager;
        this.k = function1;
        this.l = overlayBubbleWrap;
        this.m = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) this.k.invoke(this.l);
        overlayBubbleWrap.addOnAttachStateChangeListener(new a());
        this.j.a(overlayBubbleWrap);
        this.l.setBubbleTouchable(false);
        this.j.windowManager.removeViewImmediate(this.l);
        WindowManager windowManager = this.j.windowManager;
        OverlayBubbleWrap overlayBubbleWrap2 = this.l;
        windowManager.addView(overlayBubbleWrap2, overlayBubbleWrap2.getWindowLayoutParams());
    }
}
