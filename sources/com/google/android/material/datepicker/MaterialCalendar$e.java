package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import b.i.a.g.d.l;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$e extends RecyclerView$ItemDecoration {
    public final Calendar a = l.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Calendar f3034b = l.i();
    public final /* synthetic */ MaterialCalendar c;

    public MaterialCalendar$e(MaterialCalendar materialCalendar) {
        this.c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView$State recyclerView$State) {
        if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (Pair<Long, Long> pair : MaterialCalendar.access$200(this.c).getSelectedRanges()) {
                Long l = pair.first;
                if (l != null && pair.second != null) {
                    this.a.setTimeInMillis(l.longValue());
                    this.f3034b.setTimeInMillis(pair.second.longValue());
                    int iA = yearGridAdapter.a(this.a.get(1));
                    int iA2 = yearGridAdapter.a(this.f3034b.get(1));
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iA);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iA2);
                    int spanCount = iA / gridLayoutManager.getSpanCount();
                    int spanCount2 = iA2 / gridLayoutManager.getSpanCount();
                    for (int i = spanCount; i <= spanCount2; i++) {
                        View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i);
                        if (viewFindViewByPosition3 != null) {
                            int top = viewFindViewByPosition3.getTop() + MaterialCalendar.access$400(this.c).d.a.top;
                            int bottom = viewFindViewByPosition3.getBottom() - MaterialCalendar.access$400(this.c).d.a.bottom;
                            canvas.drawRect(i == spanCount ? (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft() : 0, top, i == spanCount2 ? (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft() : recyclerView.getWidth(), bottom, MaterialCalendar.access$400(this.c).h);
                        }
                    }
                }
            }
        }
    }
}
