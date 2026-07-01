package b.b.a.a;

import android.view.View;
import android.widget.ImageView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Objects;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$f extends AccessibilityDelegateCompat {
    public final /* synthetic */ a a;

    public a$f(a aVar) {
        this.a = aVar;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        d0.z.d.m.checkNotNullParameter(view, "host");
        d0.z.d.m.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        ImageView imageView = this.a.launchButton;
        Objects.requireNonNull(imageView, "null cannot be cast to non-null type android.view.View");
        accessibilityNodeInfoCompat.setTraversalAfter(imageView);
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }
}
