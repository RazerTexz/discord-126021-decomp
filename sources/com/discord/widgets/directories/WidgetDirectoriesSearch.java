package com.discord.widgets.directories;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoriesSearchBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.utilities.Loading;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.hubs.HubUtilsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.directories.DirectoryChannelItem;
import com.discord.widgets.directories.WidgetDirectoriesSearchViewModel;
import com.discord.widgets.hubs.WidgetHubAddServer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetDirectoriesSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoriesSearchBinding;", 0)};
    private final ActivityResultLauncher<Intent> activityResult;
    private final WidgetDirectoryChannelAdapter adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$configureUI$2 */
    /* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
    public static final class C82712 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C82712() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetDirectoriesSearch.this.getContext(), C5419R.attr.colorTextMuted));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$configureUI$3 */
    /* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
    public static final class C82723 extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$configureUI$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                C0870j.f524g.m160f(WidgetDirectoriesSearch.this.requireContext(), WidgetDirectoriesSearch.this.activityResult, WidgetHubAddServer.class, null);
            }
        }

        public C82723() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("addServerHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
    public static final class C82754 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C82754() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetDirectoriesSearch.this.searchForDirectories();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
    public static final class C82761 extends AbstractC12240o implements Function1<WidgetDirectoriesSearchViewModel.ViewState, Unit> {
        public C82761() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesSearchViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesSearchViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetDirectoriesSearch.this.configureUI(viewState);
        }
    }

    public WidgetDirectoriesSearch() {
        super(C5419R.layout.widget_directories_search);
        this.args = C12083g.lazy(new WidgetDirectoriesSearch$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDirectoriesSearch$binding$2.INSTANCE, null, 2, null);
        WidgetDirectoriesSearch$viewModel$2 widgetDirectoriesSearch$viewModel$2 = new WidgetDirectoriesSearch$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetDirectoriesSearchViewModel.class), new WidgetDirectoriesSearch$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetDirectoriesSearch$viewModel$2));
        this.activityResult = HubUtilsKt.getAddServerActivityResultHandler(this);
        this.adapter = new WidgetDirectoryChannelAdapter(new WidgetDirectoriesSearch$adapter$1(this));
    }

    private final void configureUI(WidgetDirectoriesSearchViewModel.ViewState state) {
        CharSequence charSequenceM213e;
        WidgetDirectoryChannelAdapter widgetDirectoryChannelAdapter = this.adapter;
        List<DirectoryEntryData> directoryEntryData = state.getDirectoryEntryData();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(directoryEntryData, 10));
        Iterator<T> it = directoryEntryData.iterator();
        while (it.hasNext()) {
            arrayList.add(new DirectoryChannelItem.DirectoryItem((DirectoryEntryData) it.next()));
        }
        widgetDirectoryChannelAdapter.setDirectoryChannelItems(arrayList);
        toggleList(!state.getDirectories().isEmpty());
        FloatingActionButton floatingActionButton = getBinding().f16456f;
        C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.search");
        WidgetDirectoriesSearchViewModel viewModel = getViewModel();
        TextInputEditText textInputEditText = getBinding().f16458h;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        floatingActionButton.setVisibility(viewModel.shouldNotSearch(String.valueOf(textInputEditText.getText())) ^ true ? 0 : 8);
        if (state.getDirectories().isEmpty() && (!C12238m.areEqual(state.getDirectoriesState(), Loading.INSTANCE))) {
            LinkifiedTextView linkifiedTextView = getBinding().f16452b;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.emptyDescription");
            TextInputEditText textInputEditText2 = getBinding().f16458h;
            C12238m.checkNotNullExpressionValue(textInputEditText2, "binding.searchBarText");
            Editable text = textInputEditText2.getText();
            if (text == null || C12103t.isBlank(text)) {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.guild_discovery_search_protip, new Object[0], new C82712());
            } else if (state.getHasAddGuildPermissions()) {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.directory_search_no_results_subtitle, new Object[0], new C82723());
            } else {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.directory_search_no_results_no_add, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
            }
            linkifiedTextView.setText(charSequenceM213e);
            TextView textView = getBinding().f16454d;
            C12238m.checkNotNullExpressionValue(textView, "binding.emptyTitle");
            TextInputEditText textInputEditText3 = getBinding().f16458h;
            C12238m.checkNotNullExpressionValue(textInputEditText3, "binding.searchBarText");
            Editable text2 = textInputEditText3.getText();
            textView.setVisibility((text2 == null || C12103t.isBlank(text2)) ^ true ? 0 : 8);
        }
    }

    private final void searchForDirectories() {
        WidgetDirectoriesSearchViewModel viewModel = getViewModel();
        long channelId = getArgs().getChannelId();
        TextInputEditText textInputEditText = getBinding().f16458h;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        viewModel.searchForDirectories(channelId, String.valueOf(textInputEditText.getText()));
        hideKeyboard(getView());
    }

    private final void toggleList(boolean showList) {
        RecyclerView recyclerView = getBinding().f16455e;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(showList ? 0 : 8);
        LinearLayout linearLayout = getBinding().f16453c;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.emptyState");
        linearLayout.setVisibility(showList ^ true ? 0 : 8);
    }

    public final WidgetDirectoryChannelAdapter getAdapter() {
        return this.adapter;
    }

    public final DirectoriesSearchArgs getArgs() {
        return (DirectoriesSearchArgs) this.args.getValue();
    }

    public final WidgetDirectoriesSearchBinding getBinding() {
        return (WidgetDirectoriesSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetDirectoriesSearchViewModel getViewModel() {
        return (WidgetDirectoriesSearchViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(final View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f16455e;
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        getBinding().f16457g.setStartIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoriesSearch.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetDirectoriesSearch.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.onBackPressed();
                }
                WidgetDirectoriesSearch.this.hideKeyboard(view);
            }
        });
        getBinding().f16456f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoriesSearch.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetDirectoriesSearch.this.searchForDirectories();
            }
        });
        TextInputLayout textInputLayout = getBinding().f16457g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.searchBar");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C82754(), 1, null);
        TextInputEditText textInputEditText = getBinding().f16458h;
        textInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.discord.widgets.directories.WidgetDirectoriesSearch$onViewBound$$inlined$apply$lambda$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                FloatingActionButton floatingActionButton = this.this$0.getBinding().f16456f;
                C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.search");
                WidgetDirectoriesSearchViewModel viewModel = this.this$0.getViewModel();
                if (text == null) {
                    text = "";
                }
                floatingActionButton.setVisibility(viewModel.shouldNotSearch(text) ^ true ? 0 : 8);
            }
        });
        C12238m.checkNotNullExpressionValue(textInputEditText, "this");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(ObservableExtensionsKt.m8518ui(getViewModel().observeViewState()), this, null, 2, null), (Class<?>) WidgetDirectoriesSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82761());
    }
}
