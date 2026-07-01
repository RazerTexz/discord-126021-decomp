package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroup;
import b.a.y.n0.SegmentedControlSegment;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SegmentedControlContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SegmentedControlContainer extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> segmentSelectedChangeListener;

    /* JADX INFO: compiled from: SegmentedControlContainer.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ SegmentedControlContainer k;

        public a(int i, SegmentedControlContainer segmentedControlContainer) {
            this.j = i;
            this.k = segmentedControlContainer;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<? super Integer, Unit> function1 = this.k.segmentSelectedChangeListener;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this.j));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedControlContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void b(SegmentedControlContainer segmentedControlContainer, int i, int i2) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        segmentedControlContainer.a(i);
    }

    public final void a(int selectedIndex) {
        int i = 0;
        for (View view : ViewGroup.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            View view2 = view;
            if (!(view2 instanceof SegmentedControlSegment)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            view2.setOnClickListener(new a(i, this));
            i = i2;
        }
        setSelectedIndex(selectedIndex);
    }

    public final void setOnSegmentSelectedChangeListener(Function1<? super Integer, Unit> listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.segmentSelectedChangeListener = listener;
    }

    public final void setSelectedIndex(int selectedIndex) {
        int i = 0;
        for (KeyEvent.Callback callback : ViewGroup.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            KeyEvent.Callback callback2 = (View) callback;
            if (!(callback2 instanceof SegmentedControlSegment)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            ((SegmentedControlSegment) callback2).a(i == selectedIndex);
            i = i2;
        }
    }
}
