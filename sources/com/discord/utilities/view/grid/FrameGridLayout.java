package com.discord.utilities.view.grid;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent$Callback;
import android.view.View;
import android.view.View$MeasureSpec;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.discord.utils.R$b;
import d0.d0.f;
import d0.t.c0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: FrameGridLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FrameGridLayout extends FrameLayout {
    private static final FrameGridLayout$Companion Companion = new FrameGridLayout$Companion(null);

    @Deprecated
    private static final int DEFAULT_MAX_LINEAR_VIEWS = 3;
    private List<? extends FrameGridLayout$Data> dataset;
    private final int maxLinearViews;
    private Function2<? super View, ? super FrameGridLayout$Data, Unit> onBindView;
    private final FrameGridLayout$SizeCalculator sizeCalculator;

    public FrameGridLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public FrameGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FrameGridLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ Function2 access$getOnBindView$p(FrameGridLayout frameGridLayout) {
        return frameGridLayout.onBindView;
    }

    public static final /* synthetic */ FrameGridLayout$PositionSpec access$layout(FrameGridLayout frameGridLayout, View view, FrameGridLayout$PositionSpec frameGridLayout$PositionSpec) {
        return frameGridLayout.layout(view, frameGridLayout$PositionSpec);
    }

    public static final /* synthetic */ void access$measure(FrameGridLayout frameGridLayout, View view, FrameGridLayout$PositionSpec frameGridLayout$PositionSpec) {
        frameGridLayout.measure(view, frameGridLayout$PositionSpec);
    }

    public static final /* synthetic */ void access$setOnBindView$p(FrameGridLayout frameGridLayout, Function2 function2) {
        frameGridLayout.onBindView = function2;
    }

    private final void addNecessaryViews() {
        if (this.dataset.size() > getChildCount()) {
            Iterator<Integer> it = f.until(getChildCount(), this.dataset.size()).iterator();
            while (it.hasNext()) {
                FrameGridLayout$Data frameGridLayout$Data = this.dataset.get(((c0) it).nextInt());
                Context context = getContext();
                m.checkNotNullExpressionValue(context, "context");
                addView(frameGridLayout$Data.createView(context));
            }
        }
    }

    private final void bindViews() {
        FrameGridLayout$bindViews$1 frameGridLayout$bindViews$1 = new FrameGridLayout$bindViews$1(this);
        FrameGridLayout$Children children = getChildren();
        List<? extends FrameGridLayout$Data> list = this.dataset;
        ArrayList<FrameGridLayout$Data> arrayList = new ArrayList();
        for (Object obj : list) {
            if (children.getBoundChildren().keySet().contains(((FrameGridLayout$Data) obj).getId())) {
                arrayList.add(obj);
            }
        }
        for (FrameGridLayout$Data frameGridLayout$Data : arrayList) {
            frameGridLayout$bindViews$1.invoke2(frameGridLayout$Data, children.getBoundChildren().get(frameGridLayout$Data.getId()));
        }
        List<? extends FrameGridLayout$Data> list2 = this.dataset;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (!children.getBoundChildren().keySet().contains(((FrameGridLayout$Data) obj2).getId())) {
                arrayList2.add(obj2);
            }
        }
        int i = 0;
        for (Object obj3 : arrayList2) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            frameGridLayout$bindViews$1.invoke2((FrameGridLayout$Data) obj3, children.getUnboundChildren().get(i));
            i = i2;
        }
    }

    private final FrameGridLayout$Children getChildren() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        IntRange intRangeUntil = f.until(0, getChildCount());
        ArrayList<KeyEvent$Callback> arrayList2 = new ArrayList(o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList2.add(getChildAt(((c0) it).nextInt()));
        }
        for (KeyEvent$Callback keyEvent$Callback : arrayList2) {
            Objects.requireNonNull(keyEvent$Callback, "null cannot be cast to non-null type com.discord.utilities.view.grid.FrameGridLayout.DataView");
            String dataId = ((FrameGridLayout$DataView) keyEvent$Callback).getDataId();
            if (dataId == null) {
                arrayList.add(keyEvent$Callback);
            } else {
                map.put(dataId, keyEvent$Callback);
            }
        }
        return new FrameGridLayout$Children(map, arrayList);
    }

    private final FrameGridLayout$PositionSpec layout(View view, FrameGridLayout$PositionSpec frameGridLayout$PositionSpec) {
        view.layout(frameGridLayout$PositionSpec.getLeft(), frameGridLayout$PositionSpec.getTop(), frameGridLayout$PositionSpec.getRight(), frameGridLayout$PositionSpec.getBottom());
        return frameGridLayout$PositionSpec;
    }

    private final void measure(View view, FrameGridLayout$PositionSpec frameGridLayout$PositionSpec) {
        view.measure(View$MeasureSpec.makeMeasureSpec(frameGridLayout$PositionSpec.getWidth(), BasicMeasure.EXACTLY), View$MeasureSpec.makeMeasureSpec(frameGridLayout$PositionSpec.getHeight(), BasicMeasure.EXACTLY));
    }

    private final void removeStaleViews() {
        List<? extends FrameGridLayout$Data> list = this.dataset;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FrameGridLayout$Data) it.next()).getId());
        }
        Set set = u.toSet(arrayList);
        Iterator<Integer> it2 = f.downTo(getChildCount() - 1, 0).iterator();
        while (it2.hasNext()) {
            int iNextInt = ((c0) it2).nextInt();
            KeyEvent$Callback childAt = getChildAt(iNextInt);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.discord.utilities.view.grid.FrameGridLayout.DataView");
            FrameGridLayout$DataView frameGridLayout$DataView = (FrameGridLayout$DataView) childAt;
            if (!u.contains(set, frameGridLayout$DataView.getDataId())) {
                frameGridLayout$DataView.onRemove();
                removeViewAt(iNextInt);
            }
        }
    }

    private final void sizeChildViews(Function2<? super View, ? super FrameGridLayout$PositionSpec, Unit> onSizeChildView) {
        Iterator<Integer> it = f.until(0, getChildCount()).iterator();
        while (it.hasNext()) {
            KeyEvent$Callback childAt = getChildAt(((c0) it).nextInt());
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.discord.utilities.view.grid.FrameGridLayout.DataView");
            String dataId = ((FrameGridLayout$DataView) childAt).getDataId();
            Iterator<? extends FrameGridLayout$Data> it2 = this.dataset.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                } else if (m.areEqual(it2.next().getId(), dataId)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                onSizeChildView.invoke(childAt, this.sizeCalculator.getItemSize(getWidth(), getHeight(), getChildCount(), i));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        sizeChildViews(new FrameGridLayout$onLayout$1(this));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        sizeChildViews(new FrameGridLayout$onMeasure$1(this));
    }

    @MainThread
    public final void setData(List<? extends FrameGridLayout$Data> data) {
        m.checkNotNullParameter(data, "data");
        this.dataset = data;
        removeStaleViews();
        addNecessaryViews();
        bindViews();
    }

    @MainThread
    public final void setOnBindView(Function2<? super View, ? super FrameGridLayout$Data, Unit> onBindView) {
        this.onBindView = onBindView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        this.dataset = n.emptyList();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$b.FrameGridLayout, 0, 0);
            m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.FrameGridLayout, 0, 0)");
            this.maxLinearViews = typedArrayObtainStyledAttributes.getInt(R$b.FrameGridLayout_fgl_max_linear_views, 3);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.maxLinearViews = 3;
        }
        this.sizeCalculator = new FrameGridLayout$SizeCalculator(this.maxLinearViews);
    }
}
