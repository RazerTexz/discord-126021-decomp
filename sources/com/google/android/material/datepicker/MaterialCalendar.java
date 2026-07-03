package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import p007b.p225i.p226a.p341g.p345d.AbstractC4398i;
import p007b.p225i.p226a.p341g.p345d.C4391b;
import p007b.p225i.p226a.p341g.p345d.C4394e;
import p007b.p225i.p226a.p341g.p345d.C4399j;
import p007b.p225i.p226a.p341g.p345d.C4401l;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends AbstractC4398i<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";

    @Nullable
    private CalendarConstraints calendarConstraints;
    private EnumC10895k calendarSelector;
    private C4391b calendarStyle;

    @Nullable
    private Month current;

    @Nullable
    private DateSelector<S> dateSelector;
    private View dayFrame;
    private RecyclerView recyclerView;

    @StyleRes
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;

    @VisibleForTesting
    public static final Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";

    @VisibleForTesting
    public static final Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";

    @VisibleForTesting
    public static final Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";

    @VisibleForTesting
    public static final Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$a */
    public class RunnableC10885a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f20957j;

        public RunnableC10885a(int i) {
            this.f20957j = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.recyclerView.smoothScrollToPosition(this.f20957j);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$b */
    public class C10886b extends AccessibilityDelegateCompat {
        public C10886b(MaterialCalendar materialCalendar) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$c */
    public class C10887c extends C4399j {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f20959j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10887c(Context context, int i, boolean z2, int i2) {
            super(context, i, z2);
            this.f20959j = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.f20959j == 0) {
                iArr[0] = MaterialCalendar.this.recyclerView.getWidth();
                iArr[1] = MaterialCalendar.this.recyclerView.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.recyclerView.getHeight();
                iArr[1] = MaterialCalendar.this.recyclerView.getHeight();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$d */
    public class C10888d implements InterfaceC10896l {
        public C10888d() {
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$e */
    public class C10889e extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        public final Calendar f20962a = C4401l.m6076i();

        /* JADX INFO: renamed from: b */
        public final Calendar f20963b = C4401l.m6076i();

        public C10889e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : MaterialCalendar.this.dateSelector.getSelectedRanges()) {
                    Long l = pair.first;
                    if (l != null && pair.second != null) {
                        this.f20962a.setTimeInMillis(l.longValue());
                        this.f20963b.setTimeInMillis(pair.second.longValue());
                        int iM9142a = yearGridAdapter.m9142a(this.f20962a.get(1));
                        int iM9142a2 = yearGridAdapter.m9142a(this.f20963b.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iM9142a);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iM9142a2);
                        int spanCount = iM9142a / gridLayoutManager.getSpanCount();
                        int spanCount2 = iM9142a2 / gridLayoutManager.getSpanCount();
                        for (int i = spanCount; i <= spanCount2; i++) {
                            View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i);
                            if (viewFindViewByPosition3 != null) {
                                int top = viewFindViewByPosition3.getTop() + MaterialCalendar.this.calendarStyle.f11587d.f11578a.top;
                                int bottom = viewFindViewByPosition3.getBottom() - MaterialCalendar.this.calendarStyle.f11587d.f11578a.bottom;
                                canvas.drawRect(i == spanCount ? (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft() : 0, top, i == spanCount2 ? (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft() : recyclerView.getWidth(), bottom, MaterialCalendar.this.calendarStyle.f11591h);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$f */
    public class C10890f extends AccessibilityDelegateCompat {
        public C10890f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setHintText(MaterialCalendar.this.dayFrame.getVisibility() == 0 ? MaterialCalendar.this.getString(C10817R.string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(C10817R.string.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$g */
    public class C10891g extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ MonthsPagerAdapter f20966a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ MaterialButton f20967b;

        public C10891g(MonthsPagerAdapter monthsPagerAdapter, MaterialButton materialButton) {
            this.f20966a = monthsPagerAdapter;
            this.f20967b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.announceForAccessibility(this.f20967b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            int iFindFirstVisibleItemPosition = i < 0 ? MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() : MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
            MaterialCalendar.this.current = this.f20966a.m9140a(iFindFirstVisibleItemPosition);
            MaterialButton materialButton = this.f20967b;
            MonthsPagerAdapter monthsPagerAdapter = this.f20966a;
            materialButton.setText(monthsPagerAdapter.f20992b.getStart().m9138m(iFindFirstVisibleItemPosition).m9137l(monthsPagerAdapter.f20991a));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$h */
    public class ViewOnClickListenerC10892h implements View.OnClickListener {
        public ViewOnClickListenerC10892h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.toggleVisibleSelector();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$i */
    public class ViewOnClickListenerC10893i implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ MonthsPagerAdapter f20970j;

        public ViewOnClickListenerC10893i(MonthsPagerAdapter monthsPagerAdapter) {
            this.f20970j = monthsPagerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindFirstVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
            if (iFindFirstVisibleItemPosition < MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
                MaterialCalendar.this.setCurrentMonth(this.f20970j.m9140a(iFindFirstVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$j */
    public class ViewOnClickListenerC10894j implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ MonthsPagerAdapter f20972j;

        public ViewOnClickListenerC10894j(MonthsPagerAdapter monthsPagerAdapter) {
            this.f20972j = monthsPagerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindLastVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
            if (iFindLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.setCurrentMonth(this.f20972j.m9140a(iFindLastVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$k */
    public enum EnumC10895k {
        DAY,
        YEAR
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$l */
    public interface InterfaceC10896l {
    }

    private void addActionsToMonthNavigation(@NonNull View view, @NonNull MonthsPagerAdapter monthsPagerAdapter) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(C10817R.id.month_navigation_fragment_toggle);
        materialButton.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(materialButton, new C10890f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C10817R.id.month_navigation_previous);
        materialButton2.setTag(NAVIGATION_PREV_TAG);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(C10817R.id.month_navigation_next);
        materialButton3.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = view.findViewById(C10817R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = view.findViewById(C10817R.id.mtrl_calendar_day_selector_frame);
        setSelector(EnumC10895k.DAY);
        materialButton.setText(this.current.m9137l(view.getContext()));
        this.recyclerView.addOnScrollListener(new C10891g(monthsPagerAdapter, materialButton));
        materialButton.setOnClickListener(new ViewOnClickListenerC10892h());
        materialButton3.setOnClickListener(new ViewOnClickListenerC10893i(monthsPagerAdapter));
        materialButton2.setOnClickListener(new ViewOnClickListenerC10894j(monthsPagerAdapter));
    }

    @NonNull
    private RecyclerView.ItemDecoration createItemDecoration() {
        return new C10889e();
    }

    @Px
    public static int getDayHeight(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(C10817R.dimen.mtrl_calendar_day_height);
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(@NonNull DateSelector<T> dateSelector, @StyleRes int i, @NonNull CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt(THEME_RES_ID_KEY, i);
        bundle.putParcelable(GRID_SELECTOR_KEY, dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints);
        bundle.putParcelable(CURRENT_MONTH_KEY, calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void postSmoothRecyclerViewScroll(int i) {
        this.recyclerView.post(new RunnableC10885a(i));
    }

    @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4398i
    public boolean addOnSelectionChangedListener(@NonNull OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.addOnSelectionChangedListener(onSelectionChangedListener);
    }

    @Nullable
    public CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    public C4391b getCalendarStyle() {
        return this.calendarStyle;
    }

    @Nullable
    public Month getCurrentMonth() {
        return this.current;
    }

    @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4398i
    @Nullable
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    @NonNull
    public LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) bundle.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.current = (Month) bundle.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new C4391b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month start = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i = C10817R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = C10817R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(C10817R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new C10886b(this));
        gridView.setAdapter((ListAdapter) new C4394e());
        gridView.setNumColumns(start.f20987m);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) viewInflate.findViewById(C10817R.id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new C10887c(getContext(), i2, false, i2));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new C10888d());
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(C10817R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C10817R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(createItemDecoration());
        }
        if (viewInflate.findViewById(C10817R.id.month_navigation_fragment_toggle) != null) {
            addActionsToMonthNavigation(viewInflate, monthsPagerAdapter);
        }
        if (!MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.m9141b(this.current));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(THEME_RES_ID_KEY, this.themeResId);
        bundle.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        bundle.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    public void setCurrentMonth(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int iM9139o = monthsPagerAdapter.f20992b.getStart().m9139o(month);
        int iM9141b = iM9139o - monthsPagerAdapter.m9141b(this.current);
        boolean z2 = Math.abs(iM9141b) > 3;
        boolean z3 = iM9141b > 0;
        this.current = month;
        if (z2 && z3) {
            this.recyclerView.scrollToPosition(iM9139o - 3);
            postSmoothRecyclerViewScroll(iM9139o);
        } else if (!z2) {
            postSmoothRecyclerViewScroll(iM9139o);
        } else {
            this.recyclerView.scrollToPosition(iM9139o + 3);
            postSmoothRecyclerViewScroll(iM9139o);
        }
    }

    public void setSelector(EnumC10895k enumC10895k) {
        this.calendarSelector = enumC10895k;
        if (enumC10895k == EnumC10895k.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).m9142a(this.current.f20986l));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
        } else if (enumC10895k == EnumC10895k.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    public void toggleVisibleSelector() {
        EnumC10895k enumC10895k = EnumC10895k.DAY;
        EnumC10895k enumC10895k2 = this.calendarSelector;
        EnumC10895k enumC10895k3 = EnumC10895k.YEAR;
        if (enumC10895k2 == enumC10895k3) {
            setSelector(enumC10895k);
        } else if (enumC10895k2 == enumC10895k) {
            setSelector(enumC10895k3);
        }
    }
}
