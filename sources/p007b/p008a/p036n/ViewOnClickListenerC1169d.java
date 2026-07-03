package p007b.p008a.p036n;

import android.view.View;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.n.d */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1169d implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ OverlayManager f1548j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Function1 f1549k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ OverlayBubbleWrap f1550l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Object f1551m;

    /* JADX INFO: renamed from: b.a.n.d$a */
    /* JADX INFO: compiled from: OverlayManager.kt */
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b.a.n.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: View.kt */
        public static final class ViewOnLayoutChangeListenerC13211a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ View f1554k;

            public ViewOnLayoutChangeListenerC13211a(View view) {
                this.f1554k = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                C12238m.checkNotNullParameter(view, "view");
                view.removeOnLayoutChangeListener(this);
                View viewFindViewWithTag = this.f1554k.findViewWithTag(ViewOnClickListenerC1169d.this.f1551m);
                C12238m.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
                ViewOnClickListenerC1169d.this.f1550l.mo390b(viewFindViewWithTag);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            C12238m.checkNotNullParameter(view, "v");
            if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
                view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC13211a(view));
                return;
            }
            View viewFindViewWithTag = view.findViewWithTag(ViewOnClickListenerC1169d.this.f1551m);
            C12238m.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
            ViewOnClickListenerC1169d.this.f1550l.mo390b(viewFindViewWithTag);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewCompat.isAttachedToWindow(ViewOnClickListenerC1169d.this.f1550l)) {
                ViewOnClickListenerC1169d.this.f1550l.setBubbleTouchable(true);
                ViewOnClickListenerC1169d.this.f1550l.mo389a(true);
            }
        }
    }

    public ViewOnClickListenerC1169d(OverlayManager overlayManager, Function1 function1, OverlayBubbleWrap overlayBubbleWrap, Object obj) {
        this.f1548j = overlayManager;
        this.f1549k = function1;
        this.f1550l = overlayBubbleWrap;
        this.f1551m = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) this.f1549k.invoke(this.f1550l);
        overlayBubbleWrap.addOnAttachStateChangeListener(new a());
        this.f1548j.m8430a(overlayBubbleWrap);
        this.f1550l.setBubbleTouchable(false);
        this.f1548j.windowManager.removeViewImmediate(this.f1550l);
        WindowManager windowManager = this.f1548j.windowManager;
        OverlayBubbleWrap overlayBubbleWrap2 = this.f1550l;
        windowManager.addView(overlayBubbleWrap2, overlayBubbleWrap2.getWindowLayoutParams());
    }
}
