package com.discord.widgets.directories;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoryCategoryBinding;
import com.discord.utilities.directories.DirectoryUtilsKt;
import com.discord.utilities.hubs.HubUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryCategory extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetDirectoryCategory.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoryCategoryBinding;", 0)};
    private final ActivityResultLauncher<Intent> activityResult;
    private final WidgetDirectoryChannelAdapter adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetDirectoryCategory() {
        super(R$layout.widget_directory_category);
        this.args = g.lazy(new WidgetDirectoryCategory$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDirectoryCategory$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetDirectoriesViewModel.class), new WidgetDirectoryCategory$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetDirectoryCategory$viewModel$2.INSTANCE));
        this.activityResult = HubUtilsKt.getAddServerActivityResultHandler(this);
        this.adapter = new WidgetDirectoryChannelAdapter(new WidgetDirectoryCategory$adapter$1(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetDirectoryCategory widgetDirectoryCategory, WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        widgetDirectoryCategory.configureUi(widgetDirectoriesViewModel$ViewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResult$p(WidgetDirectoryCategory widgetDirectoryCategory) {
        return widgetDirectoryCategory.activityResult;
    }

    private final void configureCategoryUi(WidgetDirectoriesViewModel$ViewState state) {
        List<DirectoryEntryData> listEmptyList = state.getDirectoryEntryData().get(Integer.valueOf(getArgs().getDirectoryCategory().getKey()));
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator<T> it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(new DirectoryChannelItem$DirectoryItem((DirectoryEntryData) it.next()));
        }
        List<DirectoryChannelItem> mutableList = u.toMutableList((Collection) arrayList);
        maybeAddServerRow(mutableList, state);
        this.adapter.setDirectoryChannelItems(mutableList);
    }

    private final void configureHomeUi(WidgetDirectoriesViewModel$ViewState state) {
        List<DirectoryChannelItem$DirectoryItem> directoryItems;
        List<DirectoryChannelItem$DirectoryItem> directoryItems2;
        if (state.getChannel() != null) {
            if (ChannelUtils.x(state.getChannel())) {
                WidgetDirectoryChannelAdapter widgetDirectoryChannelAdapter = this.adapter;
                List<DirectoryChannelItem> mutableList = u.toMutableList((Collection) toDirectoryItems(state.getAllDirectoryEntryData()));
                maybeAddServerRow(mutableList, state);
                widgetDirectoryChannelAdapter.setDirectoryChannelItems(mutableList);
                return;
            }
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            List<DirectoryEntryData> listSortByAdded = DirectoryUtilsKt.sortByAdded(state.getAllDirectoryEntryData());
            if (!(!listSortByAdded.isEmpty())) {
                listSortByAdded = null;
            }
            if (listSortByAdded != null && (directoryItems2 = toDirectoryItems(listSortByAdded)) != null) {
                arrayList.add(new DirectoryChannelItem$SectionHeader(2131895356));
                arrayList.addAll(directoryItems2);
                Iterator<T> it = directoryItems2.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(Long.valueOf(((DirectoryChannelItem$DirectoryItem) it.next()).getDirectoryEntryData().getEntry().getGuild().getId()));
                }
            }
            List<DirectoryEntryData> allDirectoryEntryData = state.getAllDirectoryEntryData();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : allDirectoryEntryData) {
                if (!linkedHashSet.contains(Long.valueOf(((DirectoryEntryData) obj).getEntry().getGuild().getId()))) {
                    arrayList2.add(obj);
                }
            }
            List<DirectoryEntryData> list = arrayList2.isEmpty() ^ true ? arrayList2 : null;
            if (list != null && (directoryItems = toDirectoryItems(list)) != null) {
                arrayList.add(new DirectoryChannelItem$SectionHeader(2131886413));
                arrayList.addAll(directoryItems);
            }
            this.adapter.setDirectoryChannelItems(arrayList);
        }
    }

    private final void configureUi(WidgetDirectoriesViewModel$ViewState state) {
        if (getArgs().getDirectoryCategory().ordinal() != 0) {
            configureCategoryUi(state);
        } else {
            configureHomeUi(state);
        }
    }

    private final void maybeAddServerRow(List<DirectoryChannelItem> list, WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        if (widgetDirectoriesViewModel$ViewState.getHasAddGuildPermissions()) {
            list.add(DirectoryChannelItem$AddServer.INSTANCE);
        }
    }

    private final List<DirectoryChannelItem$DirectoryItem> toDirectoryItems(List<DirectoryEntryData> list) {
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new DirectoryChannelItem$DirectoryItem((DirectoryEntryData) it.next()));
        }
        return arrayList;
    }

    public final WidgetDirectoryChannelAdapter getAdapter() {
        return this.adapter;
    }

    public final DirectoryCategoryArgs getArgs() {
        return (DirectoryCategoryArgs) this.args.getValue();
    }

    public final WidgetDirectoryCategoryBinding getBinding() {
        return (WidgetDirectoryCategoryBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetDirectoriesViewModel getViewModel() {
        return (WidgetDirectoriesViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f2364b;
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetDirectoriesViewModel$ViewState> observableY = getViewModel().observeViewState().y(WidgetDirectoryCategory$onViewBoundOrOnResume$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "viewModel\n        .obser…   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableY, this, null, 2, null), WidgetDirectoryCategory.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoryCategory$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
