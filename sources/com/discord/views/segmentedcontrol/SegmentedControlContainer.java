package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent$Callback;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import b.a.y.n0.a;
import d0.t.n;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SegmentedControlContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SegmentedControlContainer extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> segmentSelectedChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedControlContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void b(SegmentedControlContainer segmentedControlContainer, int i, int i2) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        segmentedControlContainer.a(i);
    }

    public final void a(int selectedIndex) {
        int i = 0;
        for (View view : ViewGroupKt.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            View view2 = view;
            if (!(view2 instanceof a)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            view2.setOnClickListener(new SegmentedControlContainer$a(i, this));
            i = i2;
        }
        setSelectedIndex(selectedIndex);
    }

    public final void setOnSegmentSelectedChangeListener(Function1<? super Integer, Unit> listener) {
        m.checkNotNullParameter(listener, "listener");
        this.segmentSelectedChangeListener = listener;
    }

    public final void setSelectedIndex(int selectedIndex) {
        int i = 0;
        for (KeyEvent$Callback keyEvent$Callback : ViewGroupKt.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            KeyEvent$Callback keyEvent$Callback2 = (View) keyEvent$Callback;
            if (!(keyEvent$Callback2 instanceof a)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            ((a) keyEvent$Callback2).a(i == selectedIndex);
            i = i2;
        }
    }
}
