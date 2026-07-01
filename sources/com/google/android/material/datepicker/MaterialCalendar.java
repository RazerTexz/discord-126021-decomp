package com.google.android.material.datepicker;

import android.content.Context;
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
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import b.i.a.g.d.b;
import b.i.a.g.d.e;
import b.i.a.g.d.i;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends i<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";

    @Nullable
    private CalendarConstraints calendarConstraints;
    private MaterialCalendar$k calendarSelector;
    private b calendarStyle;

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

    public static /* synthetic */ RecyclerView access$000(MaterialCalendar materialCalendar) {
        return materialCalendar.recyclerView;
    }

    public static /* synthetic */ CalendarConstraints access$100(MaterialCalendar materialCalendar) {
        return materialCalendar.calendarConstraints;
    }

    public static /* synthetic */ DateSelector access$200(MaterialCalendar materialCalendar) {
        return materialCalendar.dateSelector;
    }

    public static /* synthetic */ RecyclerView access$300(MaterialCalendar materialCalendar) {
        return materialCalendar.yearSelector;
    }

    public static /* synthetic */ b access$400(MaterialCalendar materialCalendar) {
        return materialCalendar.calendarStyle;
    }

    public static /* synthetic */ View access$500(MaterialCalendar materialCalendar) {
        return materialCalendar.dayFrame;
    }

    public static /* synthetic */ Month access$602(MaterialCalendar materialCalendar, Month month) {
        materialCalendar.current = month;
        return month;
    }

    private void addActionsToMonthNavigation(@NonNull View view, @NonNull MonthsPagerAdapter monthsPagerAdapter) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(materialButton, new MaterialCalendar$f(this));
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.month_navigation_previous);
        materialButton2.setTag(NAVIGATION_PREV_TAG);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.month_navigation_next);
        materialButton3.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.dayFrame = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        setSelector(MaterialCalendar$k.DAY);
        materialButton.setText(this.current.l(view.getContext()));
        this.recyclerView.addOnScrollListener(new MaterialCalendar$g(this, monthsPagerAdapter, materialButton));
        materialButton.setOnClickListener(new MaterialCalendar$h(this));
        materialButton3.setOnClickListener(new MaterialCalendar$i(this, monthsPagerAdapter));
        materialButton2.setOnClickListener(new MaterialCalendar$j(this, monthsPagerAdapter));
    }

    @NonNull
    private RecyclerView$ItemDecoration createItemDecoration() {
        return new MaterialCalendar$e(this);
    }

    @Px
    public static int getDayHeight(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
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
        this.recyclerView.post(new MaterialCalendar$a(this, i));
    }

    @Override // b.i.a.g.d.i
    public boolean addOnSelectionChangedListener(@NonNull OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.addOnSelectionChangedListener(onSelectionChangedListener);
    }

    @Nullable
    public CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    public b getCalendarStyle() {
        return this.calendarStyle;
    }

    @Nullable
    public Month getCurrentMonth() {
        return this.current;
    }

    @Override // b.i.a.g.d.i
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
        this.calendarStyle = new b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month start = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i = R$layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = R$layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new MaterialCalendar$b(this));
        gridView.setAdapter((ListAdapter) new e());
        gridView.setNumColumns(start.m);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new MaterialCalendar$c(this, getContext(), i2, false, i2));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new MaterialCalendar$d(this));
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(createItemDecoration());
        }
        if (viewInflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            addActionsToMonthNavigation(viewInflate, monthsPagerAdapter);
        }
        if (!MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.b(this.current));
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
        int iO = monthsPagerAdapter.f3036b.getStart().o(month);
        int iB = iO - monthsPagerAdapter.b(this.current);
        boolean z2 = Math.abs(iB) > 3;
        boolean z3 = iB > 0;
        this.current = month;
        if (z2 && z3) {
            this.recyclerView.scrollToPosition(iO - 3);
            postSmoothRecyclerViewScroll(iO);
        } else if (!z2) {
            postSmoothRecyclerViewScroll(iO);
        } else {
            this.recyclerView.scrollToPosition(iO + 3);
            postSmoothRecyclerViewScroll(iO);
        }
    }

    public void setSelector(MaterialCalendar$k materialCalendar$k) {
        this.calendarSelector = materialCalendar$k;
        if (materialCalendar$k == MaterialCalendar$k.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).a(this.current.l));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
        } else if (materialCalendar$k == MaterialCalendar$k.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    public void toggleVisibleSelector() {
        MaterialCalendar$k materialCalendar$k = MaterialCalendar$k.DAY;
        MaterialCalendar$k materialCalendar$k2 = this.calendarSelector;
        MaterialCalendar$k materialCalendar$k3 = MaterialCalendar$k.YEAR;
        if (materialCalendar$k2 == materialCalendar$k3) {
            setSelector(materialCalendar$k);
        } else if (materialCalendar$k2 == materialCalendar$k) {
            setSelector(materialCalendar$k3);
        }
    }
}
