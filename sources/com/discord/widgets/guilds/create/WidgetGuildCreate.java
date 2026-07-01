package com.discord.widgets.guilds.create;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ScreenTitleView;
import com.discord.widgets.guilds.create.GuildCreateCloneViews;
import com.discord.widgets.guilds.create.WidgetGuildCreateViewModel;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.discord.widgets.nux.WidgetNuxChannelPrompt;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildCreate extends AppFragment {
    public static final String ANALYTICS_SOURCE = "Guild Create";
    public static final String EXTRA_OPTIONS = "com.discord.intent.extra.EXTRA_OPTIONS";
    private static final String GUIDELINES_URL = "https://discord.com/guidelines";

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String currentImageUri;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildCreate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCreateBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetGuildCreate.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, Options options) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(options, "options");
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildCreate.EXTRA_OPTIONS, options);
            AppScreen2.d(context, WidgetGuildCreate.class, intent);
        }

        public final void showFragment(AppFragment fragment, Options options) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(options, "options");
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetGuildCreate.EXTRA_OPTIONS, options);
            AppScreen2.g(AppScreen2.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetGuildCreate.class, 0, true, null, bundle, 40);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCreate.kt */
    public static final /* data */ class Options implements Parcelable {
        public static final Parcelable.Creator<Options> CREATOR = new Creator();
        private final String analyticsLocation;
        private final boolean closeWithResult;
        private final String customTitle;
        private final boolean showChannelPrompt;
        private final StockGuildTemplate template;

        public static class Creator implements Parcelable.Creator<Options> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Options(parcel.readString(), (StockGuildTemplate) Enum.valueOf(StockGuildTemplate.class, parcel.readString()), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options[] newArray(int i) {
                return new Options[i];
            }
        }

        public Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3) {
            Intrinsics3.checkNotNullParameter(str, "analyticsLocation");
            Intrinsics3.checkNotNullParameter(stockGuildTemplate, "template");
            this.analyticsLocation = str;
            this.template = stockGuildTemplate;
            this.showChannelPrompt = z2;
            this.customTitle = str2;
            this.closeWithResult = z3;
        }

        public static /* synthetic */ Options copy$default(Options options, String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = options.analyticsLocation;
            }
            if ((i & 2) != 0) {
                stockGuildTemplate = options.template;
            }
            StockGuildTemplate stockGuildTemplate2 = stockGuildTemplate;
            if ((i & 4) != 0) {
                z2 = options.showChannelPrompt;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                str2 = options.customTitle;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                z3 = options.closeWithResult;
            }
            return options.copy(str, stockGuildTemplate2, z4, str3, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnalyticsLocation() {
            return this.analyticsLocation;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StockGuildTemplate getTemplate() {
            return this.template;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowChannelPrompt() {
            return this.showChannelPrompt;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCustomTitle() {
            return this.customTitle;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCloseWithResult() {
            return this.closeWithResult;
        }

        public final Options copy(String analyticsLocation, StockGuildTemplate template, boolean showChannelPrompt, String customTitle, boolean closeWithResult) {
            Intrinsics3.checkNotNullParameter(analyticsLocation, "analyticsLocation");
            Intrinsics3.checkNotNullParameter(template, "template");
            return new Options(analyticsLocation, template, showChannelPrompt, customTitle, closeWithResult);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Options)) {
                return false;
            }
            Options options = (Options) other;
            return Intrinsics3.areEqual(this.analyticsLocation, options.analyticsLocation) && Intrinsics3.areEqual(this.template, options.template) && this.showChannelPrompt == options.showChannelPrompt && Intrinsics3.areEqual(this.customTitle, options.customTitle) && this.closeWithResult == options.closeWithResult;
        }

        public final String getAnalyticsLocation() {
            return this.analyticsLocation;
        }

        public final boolean getCloseWithResult() {
            return this.closeWithResult;
        }

        public final String getCustomTitle() {
            return this.customTitle;
        }

        public final boolean getShowChannelPrompt() {
            return this.showChannelPrompt;
        }

        public final StockGuildTemplate getTemplate() {
            return this.template;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            String str = this.analyticsLocation;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            StockGuildTemplate stockGuildTemplate = this.template;
            int iHashCode2 = (iHashCode + (stockGuildTemplate != null ? stockGuildTemplate.hashCode() : 0)) * 31;
            boolean z2 = this.showChannelPrompt;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            String str2 = this.customTitle;
            int iHashCode3 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z3 = this.closeWithResult;
            return iHashCode3 + (z3 ? 1 : z3);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Options(analyticsLocation=");
            sbU.append(this.analyticsLocation);
            sbU.append(", template=");
            sbU.append(this.template);
            sbU.append(", showChannelPrompt=");
            sbU.append(this.showChannelPrompt);
            sbU.append(", customTitle=");
            sbU.append(this.customTitle);
            sbU.append(", closeWithResult=");
            return outline.O(sbU, this.closeWithResult, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.analyticsLocation);
            parcel.writeString(this.template.name());
            parcel.writeInt(this.showChannelPrompt ? 1 : 0);
            parcel.writeString(this.customTitle);
            parcel.writeInt(this.closeWithResult ? 1 : 0);
        }

        public /* synthetic */ Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? StockGuildTemplate.CREATE : stockGuildTemplate, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? false : z3);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCreate.kt */
    public static final /* data */ class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        private final long guildId;

        public static class Creator implements Parcelable.Creator<Result> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Result createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Result(parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result(long j) {
            this.guildId = j;
        }

        public static /* synthetic */ Result copy$default(Result result, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = result.guildId;
            }
            return result.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Result copy(long guildId) {
            return new Result(guildId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Result) && this.guildId == ((Result) other).guildId;
            }
            return true;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return b.a(this.guildId);
        }

        public String toString() {
            return outline.C(outline.U("Result(guildId="), this.guildId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCreate.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGuildCreateViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildCreate.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCreate.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetGuildCreateViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildCreate.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCreate.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildCreate.this.getViewModel().updateGuildName(str);
        }
    }

    public WidgetGuildCreate() {
        this(0, 1, null);
    }

    public WidgetGuildCreate(@LayoutRes int i) {
        super(i);
        this.args = LazyJVM.lazy(new WidgetGuildCreate$$special$$inlined$args$1(this, EXTRA_OPTIONS));
        WidgetGuildCreate4 widgetGuildCreate4 = new WidgetGuildCreate4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildCreateViewModel.class), new WidgetGuildCreate$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildCreate4));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildCreate2.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, new WidgetGuildCreate3(this), 3);
    }

    private final WidgetGuildCreateBinding getBinding() {
        return (WidgetGuildCreateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildCreateViewModel getViewModel() {
        return (WidgetGuildCreateViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildCreateViewModel.Event event) {
        if (event instanceof WidgetGuildCreateViewModel.Event.ShowToast) {
            AppToast.i(this, ((WidgetGuildCreateViewModel.Event.ShowToast) event).getStringResId(), 0, 4);
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.LaunchChannelPrompt) {
            WidgetNuxChannelPrompt.INSTANCE.launch(requireContext(), ((WidgetGuildCreateViewModel.Event.LaunchChannelPrompt) event).getGuildId());
            requireActivity().finish();
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.CloseWithResult) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.setResult(-1, AnimatableValueParser.g2(new Result(((WidgetGuildCreateViewModel.Event.CloseWithResult) event).getGuildId())));
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) {
            if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), "Guild Create", 1, null);
                AppScreen2.c(requireContext(), false, null, 6);
            } else {
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context contextRequireContext = requireContext();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.launch(contextRequireContext, parentFragmentManager, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? false : true, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Guild Create");
            }
            requireActivity().finish();
        }
    }

    public void configureUI(WidgetGuildCreateViewModel.ViewState viewState) {
        ScreenTitleView screenTitleView;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (!Intrinsics3.areEqual(viewState, WidgetGuildCreateViewModel.ViewState.Uninitialized.INSTANCE) && (viewState instanceof WidgetGuildCreateViewModel.ViewState.Initialized)) {
            WidgetGuildCreateViewModel.ViewState.Initialized initialized = (WidgetGuildCreateViewModel.ViewState.Initialized) viewState;
            String guildName = initialized.getGuildName(requireContext());
            if (!Intrinsics3.areEqual(guildName, ViewExtensions.getTextOrEmpty(getViews().getGuildCreateName()))) {
                ViewExtensions.setText(getViews().getGuildCreateName(), guildName);
            }
            if (!Intrinsics3.areEqual(this.currentImageUri, initialized.getGuildIconUri())) {
                getViews().getIconUploaderPlaceholderGroup().setVisibility(initialized.getGuildIconUri() == null ? 0 : 8);
                IconUtils.setIcon$default(getViews().getIconUploaderImage(), initialized.getGuildIconUri(), R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                this.currentImageUri = initialized.getGuildIconUri();
            }
            if (initialized.getCustomTitle() != null && (screenTitleView = getViews().getScreenTitleView()) != null) {
                screenTitleView.setTitle(initialized.getCustomTitle());
            }
            getViews().getGuildCreateButton().setIsLoading(initialized.isBusy());
        }
    }

    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(R.string.create_server_default_server_name_format, getArgs().getTemplate(), null, getArgs().getShowChannelPrompt(), getArgs().getAnalyticsLocation(), getArgs().getCustomTitle(), getArgs().getCloseWithResult(), null, null, null, 896, null);
    }

    public final Options getArgs() {
        return (Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews.Companion companion = GuildCreateCloneViews.INSTANCE;
        WidgetGuildCreateBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        return companion.from(binding);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, new Action1<String>() { // from class: com.discord.widgets.guilds.create.WidgetGuildCreate.onImageChosen.1
            @Override // rx.functions.Action1
            public final void call(String str) {
                WidgetGuildCreate.this.getViewModel().updateGuildIconUri(str);
            }
        }, ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(requireContext(), uri, mimeType, new Action1<String>() { // from class: com.discord.widgets.guilds.create.WidgetGuildCreate.onImageCropped.1
            @Override // rx.functions.Action1
            public final void call(String str) {
                WidgetGuildCreate.this.getViewModel().updateGuildIconUri(str);
            }
        });
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        getViews().getGuildCreateIconUploader().setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.create.WidgetGuildCreate.onResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildCreate widgetGuildCreate = WidgetGuildCreate.this;
                widgetGuildCreate.hideKeyboard(widgetGuildCreate.getViews().getGuildCreateName());
                WidgetGuildCreate.this.openMediaChooser();
            }
        });
        FormatUtils.m(getViews().getGuidelinesTextView(), R.string.create_server_guidelines, new Object[]{GUIDELINES_URL}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        EditText editText = getViews().getGuildCreateName().getEditText();
        if (editText != null) {
            TextWatcher4.addLifecycleAwareTextWatcher(editText, this, new AnonymousClass4());
        }
        getViews().getGuildCreateButton().setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.create.WidgetGuildCreate.onResume.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildCreate.this.getViewModel().createGuild(WidgetGuildCreate.this.requireContext());
                WidgetGuildCreate widgetGuildCreate = WidgetGuildCreate.this;
                widgetGuildCreate.hideKeyboard(widgetGuildCreate.getView());
            }
        });
    }

    public /* synthetic */ WidgetGuildCreate(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_guild_create : i);
    }
}
