package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDebuggingAdapterItemBinding;
import com.discord.databinding.WidgetDebuggingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging extends AppFragment {
    private static final int COLLAPSED_MAX_LINES = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Boolean> filterSubject;
    private Adapter logsAdapter;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetDebugging.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDebuggingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<AppLog.LoggedItem> {

        /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$1 */
        /* JADX INFO: compiled from: WidgetDebugging.kt */
        public static final class C82631 extends AbstractC12240o implements Function2<List<? extends AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>, Unit> {
            public final /* synthetic */ RecyclerView $recycler;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C82631(RecyclerView recyclerView) {
                super(2);
                this.$recycler = recyclerView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AppLog.LoggedItem> list, List<? extends AppLog.LoggedItem> list2) {
                invoke2((List<AppLog.LoggedItem>) list, (List<AppLog.LoggedItem>) list2);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
                C12238m.checkNotNullParameter(list, "<anonymous parameter 0>");
                C12238m.checkNotNullParameter(list2, "<anonymous parameter 1>");
                RecyclerView.LayoutManager layoutManager = this.$recycler.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                    this.$recycler.scrollToPosition(0);
                }
            }
        }

        /* JADX INFO: compiled from: WidgetDebugging.kt */
        public static final class Item extends MGRecyclerViewHolder<Adapter, AppLog.LoggedItem> {
            private final WidgetDebuggingAdapterItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                C12238m.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(C5419R.id.log_message);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.log_message)));
                }
                WidgetDebuggingAdapterItemBinding widgetDebuggingAdapterItemBinding = new WidgetDebuggingAdapterItemBinding((LinearLayout) view, textView);
                C12238m.checkNotNullExpressionValue(widgetDebuggingAdapterItemBinding, "WidgetDebuggingAdapterItemBinding.bind(itemView)");
                this.binding = widgetDebuggingAdapterItemBinding;
            }

            @ColorInt
            private final int getColor(Context context, int priority) {
                if (priority == 2) {
                    return ColorCompat.getThemedColor(context, C5419R.attr.primary_300);
                }
                if (priority == 3) {
                    return ColorCompat.getColor(context, C5419R.color.status_green_600);
                }
                if (priority != 5) {
                    return priority != 6 ? ColorCompat.getThemedColor(context, C5419R.attr.primary_100) : ColorCompat.getColor(context, C5419R.color.status_red_500);
                }
                return ColorCompat.getColor(context, C5419R.color.status_yellow_500);
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0046  */
            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            @SuppressLint({"SetTextI18n"})
            public void onConfigure(int position, AppLog.LoggedItem data) {
                String string;
                C12238m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                TextView textView = this.binding.f16448b;
                textView.setTextColor(getColor(C1643a.m821I(textView, "binding.logMessage", "binding.logMessage.context"), data.priority));
                TextView textView2 = this.binding.f16448b;
                C12238m.checkNotNullExpressionValue(textView2, "binding.logMessage");
                StringBuilder sb = new StringBuilder();
                sb.append(data.message);
                Throwable th = data.throwable;
                if (th != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('\n');
                    sb2.append(th);
                    string = sb2.toString();
                    if (string == null) {
                        string = "";
                    }
                } else {
                    string = "";
                }
                sb.append(string);
                textView2.setText(sb.toString());
                TextView textView3 = this.binding.f16448b;
                C12238m.checkNotNullExpressionValue(textView3, "binding.logMessage");
                textView3.setMaxLines(2);
                LinearLayout linearLayout = this.binding.f16447a;
                C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(linearLayout, new WidgetDebugging$Adapter$Item$onConfigure$2(this));
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.debugging.WidgetDebugging$Adapter$Item$onConfigure$3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TextView textView4 = this.this$0.binding.f16448b;
                        C12238m.checkNotNullExpressionValue(textView4, "binding.logMessage");
                        TextView textView5 = this.this$0.binding.f16448b;
                        C12238m.checkNotNullExpressionValue(textView5, "binding.logMessage");
                        textView4.setMaxLines(textView5.getMaxLines() == Integer.MAX_VALUE ? 2 : Integer.MAX_VALUE);
                        this.this$0.itemView.requestLayout();
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recycler");
            setOnUpdated(new C82631(recyclerView));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, AppLog.LoggedItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new Item(C5419R.layout.widget_debugging_adapter_item, this);
            }
            throw invalidViewTypeException(viewType);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public AppLog.LoggedItem getItem(int position) {
            return getInternalData().get((getInternalData().size() - 1) - position);
        }
    }

    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetDebugging.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final /* data */ class Model {
        private final boolean isFiltered;
        private final List<AppLog.LoggedItem> logs;

        public Model(List<AppLog.LoggedItem> list, boolean z2) {
            C12238m.checkNotNullParameter(list, "logs");
            this.logs = list;
            this.isFiltered = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.logs;
            }
            if ((i & 2) != 0) {
                z2 = model.isFiltered;
            }
            return model.copy(list, z2);
        }

        public final List<AppLog.LoggedItem> component1() {
            return this.logs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsFiltered() {
            return this.isFiltered;
        }

        public final Model copy(List<AppLog.LoggedItem> logs, boolean isFiltered) {
            C12238m.checkNotNullParameter(logs, "logs");
            return new Model(logs, isFiltered);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.logs, model.logs) && this.isFiltered == model.isFiltered;
        }

        public final List<AppLog.LoggedItem> getLogs() {
            return this.logs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            List<AppLog.LoggedItem> list = this.logs;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z2 = this.isFiltered;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isFiltered() {
            return this.isFiltered;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(logs=");
            sbM833U.append(this.logs);
            sbM833U.append(", isFiltered=");
            return C1643a.m827O(sbM833U, this.isFiltered, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final /* synthetic */ class C82694 extends C12236k implements Function1<Model, Unit> {
        public C82694(WidgetDebugging widgetDebugging) {
            super(1, widgetDebugging, WidgetDebugging.class, "configureUI", "configureUI(Lcom/discord/widgets/debugging/WidgetDebugging$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetDebugging) this.receiver).configureUI(model);
        }
    }

    public WidgetDebugging() {
        super(C5419R.layout.widget_debugging);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDebugging$binding$2.INSTANCE, null, 2, null);
        this.filterSubject = BehaviorSubject.m11130l0(Boolean.TRUE);
    }

    private final void configureUI(final Model model) {
        Adapter adapter = this.logsAdapter;
        if (adapter != null) {
            adapter.setData(model.getLogs());
        }
        setActionBarOptionsMenu(C5419R.menu.menu_debugging, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.debugging.WidgetDebugging.configureUI.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_debugging_filter) {
                    return;
                }
                boolean z2 = !menuItem.isChecked();
                menuItem.setChecked(z2);
                WidgetDebugging.this.filterSubject.onNext(Boolean.valueOf(z2));
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.debugging.WidgetDebugging.configureUI.2
            @Override // p658rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_debugging_filter);
                C12238m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_debugging_filter)");
                menuItemFindItem.setChecked(model.isFiltered());
            }
        });
    }

    private final WidgetDebuggingBinding getBinding() {
        return (WidgetDebuggingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16450b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.debuggingLogs");
        this.logsAdapter = (Adapter) companion.configure(new Adapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f16450b;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.debuggingLogs");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.debug);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Objects.requireNonNull(AppLog.f14950g);
        Observable observableM11112r = ObservableExtensionsKt.computationBuffered(AppLog.logsSubject).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "logsSubject\n          .c…  .distinctUntilChanged()");
        Observable observableM11076j = Observable.m11076j(observableM11112r.m11101a(200L, TimeUnit.MILLISECONDS).m11118y(new InterfaceC12589b<List<AppLog.LoggedItem>, Boolean>() { // from class: com.discord.widgets.debugging.WidgetDebugging.onViewBoundOrOnResume.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(List<AppLog.LoggedItem> list) {
                C12238m.checkNotNullExpressionValue(list, "it");
                return Boolean.valueOf(!list.isEmpty());
            }
        }).m11091Q(new ArrayList(), new Func2<List<? extends AppLog.LoggedItem>, List<AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>>() { // from class: com.discord.widgets.debugging.WidgetDebugging.onViewBoundOrOnResume.2
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ List<? extends AppLog.LoggedItem> call(List<? extends AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
                return call2((List<AppLog.LoggedItem>) list, list2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<AppLog.LoggedItem> call2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
                C12238m.checkNotNullExpressionValue(list, "existingLogs");
                C12238m.checkNotNullExpressionValue(list2, "newLogs");
                return C12163u.plus((Collection) list, (Iterable) list2);
            }
        }), this.filterSubject.m11112r(), new Func2<List<? extends AppLog.LoggedItem>, Boolean, Model>() { // from class: com.discord.widgets.debugging.WidgetDebugging.onViewBoundOrOnResume.3
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Model call(List<? extends AppLog.LoggedItem> list, Boolean bool) {
                return call2((List<AppLog.LoggedItem>) list, bool);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Model call2(List<AppLog.LoggedItem> list, Boolean bool) {
                C12238m.checkNotNullExpressionValue(bool, "isFiltered");
                if (bool.booleanValue()) {
                    ArrayList arrayListM840a0 = C1643a.m840a0(list, "logs");
                    for (Object obj : list) {
                        if (((AppLog.LoggedItem) obj).priority > 2) {
                            arrayListM840a0.add(obj);
                        }
                    }
                    list = arrayListM840a0;
                }
                C12238m.checkNotNullExpressionValue(list, "filteredLogs");
                return new Model(list, bool.booleanValue());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…gs, isFiltered)\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableM11076j), this, null, 2, null), (Class<?>) WidgetDebugging.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82694(this));
    }
}
