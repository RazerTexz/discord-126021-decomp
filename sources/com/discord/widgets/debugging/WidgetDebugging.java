package com.discord.widgets.debugging;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDebuggingBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging extends AppFragment {
    private static final int COLLAPSED_MAX_LINES = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Boolean> filterSubject;
    private WidgetDebugging$Adapter logsAdapter;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetDebugging.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDebuggingBinding;", 0)};
    public static final WidgetDebugging$Companion Companion = new WidgetDebugging$Companion(null);

    public WidgetDebugging() {
        super(R$layout.widget_debugging);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDebugging$binding$2.INSTANCE, null, 2, null);
        this.filterSubject = BehaviorSubject.l0(Boolean.TRUE);
    }

    public static final /* synthetic */ void access$configureUI(WidgetDebugging widgetDebugging, WidgetDebugging$Model widgetDebugging$Model) {
        widgetDebugging.configureUI(widgetDebugging$Model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterSubject$p(WidgetDebugging widgetDebugging) {
        return widgetDebugging.filterSubject;
    }

    private final void configureUI(WidgetDebugging$Model model) {
        WidgetDebugging$Adapter widgetDebugging$Adapter = this.logsAdapter;
        if (widgetDebugging$Adapter != null) {
            widgetDebugging$Adapter.setData(model.getLogs());
        }
        setActionBarOptionsMenu(R$menu.menu_debugging, new WidgetDebugging$configureUI$1(this), new WidgetDebugging$configureUI$2(model));
    }

    private final WidgetDebuggingBinding getBinding() {
        return (WidgetDebuggingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2362b;
        m.checkNotNullExpressionValue(recyclerView, "binding.debuggingLogs");
        this.logsAdapter = (WidgetDebugging$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetDebugging$Adapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f2362b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.debuggingLogs");
        RecyclerView$LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131888360);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Objects.requireNonNull(AppLog.g);
        Observable observableR = ObservableExtensionsKt.computationBuffered(AppLog.logsSubject).r();
        m.checkNotNullExpressionValue(observableR, "logsSubject\n          .c…  .distinctUntilChanged()");
        Observable observableJ = Observable.j(observableR.a(200L, TimeUnit.MILLISECONDS).y(WidgetDebugging$onViewBoundOrOnResume$1.INSTANCE).Q(new ArrayList(), WidgetDebugging$onViewBoundOrOnResume$2.INSTANCE), this.filterSubject.r(), WidgetDebugging$onViewBoundOrOnResume$3.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…gs, isFiltered)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableJ), this, null, 2, null), WidgetDebugging.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDebugging$onViewBoundOrOnResume$4(this), 62, (Object) null);
    }
}
