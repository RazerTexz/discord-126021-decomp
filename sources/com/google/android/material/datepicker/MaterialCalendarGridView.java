package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import p007b.p225i.p226a.p341g.p345d.C4391b;
import p007b.p225i.p226a.p341g.p345d.C4395f;
import p007b.p225i.p226a.p341g.p345d.C4396g;
import p007b.p225i.p226a.p341g.p345d.C4401l;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: j */
    public final Calendar f20977j;

    /* JADX INFO: renamed from: k */
    public final boolean f20978k;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f20977j = C4401l.m6076i();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(C10817R.id.cancel_button);
            setNextFocusRightId(C10817R.id.confirm_button);
        }
        this.f20978k = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new C4395f(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4396g getAdapter() {
        return (C4396g) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas canvas) {
        int iM6062a;
        int width;
        int iM6062a2;
        int width2;
        int width3;
        int i;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        C4396g adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f11608l;
        C4391b c4391b = adapter.f11610n;
        Long item = adapter.getItem(adapter.m6063b());
        Long item2 = adapter.getItem(adapter.m6065d());
        for (Pair<Long, Long> pair : dateSelector.getSelectedRanges()) {
            Long l = pair.first;
            if (l != null) {
                if (pair.second != null) {
                    long jLongValue = l.longValue();
                    long jLongValue2 = pair.second.longValue();
                    Long lValueOf = Long.valueOf(jLongValue);
                    Long lValueOf2 = Long.valueOf(jLongValue2);
                    if (!(item == null || item2 == null || lValueOf == null || lValueOf2 == null || lValueOf.longValue() > item2.longValue() || lValueOf2.longValue() < item.longValue())) {
                        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
                        if (jLongValue < item.longValue()) {
                            iM6062a = adapter.m6063b();
                            width = iM6062a % adapter.f11607k.f20987m == 0 ? 0 : !zIsLayoutRtl ? materialCalendarGridView.getChildAt(iM6062a - 1).getRight() : materialCalendarGridView.getChildAt(iM6062a - 1).getLeft();
                        } else {
                            materialCalendarGridView.f20977j.setTimeInMillis(jLongValue);
                            iM6062a = adapter.m6062a(materialCalendarGridView.f20977j.get(5));
                            View childAt = materialCalendarGridView.getChildAt(iM6062a);
                            width = (childAt.getWidth() / 2) + childAt.getLeft();
                        }
                        if (jLongValue2 > item2.longValue()) {
                            iM6062a2 = Math.min(adapter.m6065d(), getChildCount() - 1);
                            width2 = (iM6062a2 + 1) % adapter.f11607k.f20987m == 0 ? getWidth() : !zIsLayoutRtl ? materialCalendarGridView.getChildAt(iM6062a2).getRight() : materialCalendarGridView.getChildAt(iM6062a2).getLeft();
                        } else {
                            materialCalendarGridView.f20977j.setTimeInMillis(jLongValue2);
                            iM6062a2 = adapter.m6062a(materialCalendarGridView.f20977j.get(5));
                            View childAt2 = materialCalendarGridView.getChildAt(iM6062a2);
                            width2 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        int itemId = (int) adapter.getItemId(iM6062a);
                        int itemId2 = (int) adapter.getItemId(iM6062a2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt3.getTop() + c4391b.f11584a.f11578a.top;
                            int bottom = childAt3.getBottom() - c4391b.f11584a.f11578a.bottom;
                            if (zIsLayoutRtl) {
                                int i2 = iM6062a2 > numColumns2 ? 0 : width2;
                                width3 = numColumns > iM6062a ? getWidth() : width;
                                i = i2;
                            } else {
                                i = numColumns > iM6062a ? 0 : width;
                                width3 = iM6062a2 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i, top, width3, bottom, c4391b.f11591h);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter = adapter;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
            adapter = adapter;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z2, int i, Rect rect) {
        if (!z2) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(getAdapter().m6065d());
        } else if (i == 130) {
            setSelection(getAdapter().m6063b());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().m6063b()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().m6063b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.f20978k) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().m6063b()) {
            super.setSelection(getAdapter().m6063b());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof C4396g)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), C4396g.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
