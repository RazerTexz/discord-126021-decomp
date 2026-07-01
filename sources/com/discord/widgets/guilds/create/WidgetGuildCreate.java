package com.discord.widgets.guilds.create;

import android.content.Context;
import android.net.Uri;
import android.widget.EditText;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.d.m;
import b.a.k.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ScreenTitleView;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$Companion;
import com.discord.widgets.nux.WidgetNuxChannelPrompt;
import d0.g;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

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
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildCreate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCreateBinding;", 0)};
    public static final WidgetGuildCreate$Companion Companion = new WidgetGuildCreate$Companion(null);

    public WidgetGuildCreate() {
        this(0, 1, null);
    }

    public WidgetGuildCreate(@LayoutRes int i) {
        super(i);
        this.args = g.lazy(new WidgetGuildCreate$$special$$inlined$args$1(this, EXTRA_OPTIONS));
        WidgetGuildCreate$viewModel$2 widgetGuildCreate$viewModel$2 = new WidgetGuildCreate$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildCreateViewModel.class), new WidgetGuildCreate$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildCreate$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildCreate$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildCreate$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ WidgetGuildCreateViewModel access$getViewModel$p(WidgetGuildCreate widgetGuildCreate) {
        return widgetGuildCreate.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildCreate widgetGuildCreate, WidgetGuildCreateViewModel$Event widgetGuildCreateViewModel$Event) {
        widgetGuildCreate.handleEvent(widgetGuildCreateViewModel$Event);
    }

    private final WidgetGuildCreateBinding getBinding() {
        return (WidgetGuildCreateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildCreateViewModel getViewModel() {
        return (WidgetGuildCreateViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildCreateViewModel$Event event) {
        if (event instanceof WidgetGuildCreateViewModel$Event$ShowToast) {
            m.i(this, ((WidgetGuildCreateViewModel$Event$ShowToast) event).getStringResId(), 0, 4);
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel$Event$LaunchChannelPrompt) {
            WidgetNuxChannelPrompt.Companion.launch(requireContext(), ((WidgetGuildCreateViewModel$Event$LaunchChannelPrompt) event).getGuildId());
            requireActivity().finish();
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel$Event$CloseWithResult) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, d.g2(new WidgetGuildCreate$Result(((WidgetGuildCreateViewModel$Event$CloseWithResult) event).getGuildId())));
                activity.finish();
                return;
            }
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen) {
            if (GuildInviteShareSheetFeatureFlag.Companion.getINSTANCE().isEnabled()) {
                WidgetGuildInviteShareSheet$Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.Companion, null, ((WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen) event).getGuildId(), "Guild Create", 1, null);
                j.c(requireContext(), false, null, 6);
            } else {
                WidgetGuildInviteShare$Companion widgetGuildInviteShare$Companion = WidgetGuildInviteShare.Companion;
                Context contextRequireContext = requireContext();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetGuildInviteShare$Companion.launch$default(widgetGuildInviteShare$Companion, contextRequireContext, parentFragmentManager, ((WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen) event).getGuildId(), null, true, null, null, "Guild Create", 96, null);
            }
            requireActivity().finish();
        }
    }

    public void configureUI(WidgetGuildCreateViewModel$ViewState viewState) {
        ScreenTitleView screenTitleView;
        d0.z.d.m.checkNotNullParameter(viewState, "viewState");
        if (!d0.z.d.m.areEqual(viewState, WidgetGuildCreateViewModel$ViewState$Uninitialized.INSTANCE) && (viewState instanceof WidgetGuildCreateViewModel$ViewState$Initialized)) {
            WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized = (WidgetGuildCreateViewModel$ViewState$Initialized) viewState;
            String guildName = widgetGuildCreateViewModel$ViewState$Initialized.getGuildName(requireContext());
            if (!d0.z.d.m.areEqual(guildName, ViewExtensions.getTextOrEmpty(getViews().getGuildCreateName()))) {
                ViewExtensions.setText(getViews().getGuildCreateName(), guildName);
            }
            if (!d0.z.d.m.areEqual(this.currentImageUri, widgetGuildCreateViewModel$ViewState$Initialized.getGuildIconUri())) {
                getViews().getIconUploaderPlaceholderGroup().setVisibility(widgetGuildCreateViewModel$ViewState$Initialized.getGuildIconUri() == null ? 0 : 8);
                IconUtils.setIcon$default(getViews().getIconUploaderImage(), widgetGuildCreateViewModel$ViewState$Initialized.getGuildIconUri(), 2131165302, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
                this.currentImageUri = widgetGuildCreateViewModel$ViewState$Initialized.getGuildIconUri();
            }
            if (widgetGuildCreateViewModel$ViewState$Initialized.getCustomTitle() != null && (screenTitleView = getViews().getScreenTitleView()) != null) {
                screenTitleView.setTitle(widgetGuildCreateViewModel$ViewState$Initialized.getCustomTitle());
            }
            getViews().getGuildCreateButton().setIsLoading(widgetGuildCreateViewModel$ViewState$Initialized.isBusy());
        }
    }

    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(2131888245, getArgs().getTemplate(), null, getArgs().getShowChannelPrompt(), getArgs().getAnalyticsLocation(), getArgs().getCustomTitle(), getArgs().getCloseWithResult(), null, null, null, 896, null);
    }

    public final WidgetGuildCreate$Options getArgs() {
        return (WidgetGuildCreate$Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews$Companion guildCreateCloneViews$Companion = GuildCreateCloneViews.Companion;
        WidgetGuildCreateBinding binding = getBinding();
        d0.z.d.m.checkNotNullExpressionValue(binding, "binding");
        return guildCreateCloneViews$Companion.from(binding);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        d0.z.d.m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        d0.z.d.m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, new WidgetGuildCreate$onImageChosen$1(this), ImageUploadDialog$PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        d0.z.d.m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        d0.z.d.m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(requireContext(), uri, mimeType, new WidgetGuildCreate$onImageCropped$1(this));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildCreate$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildCreate$onResume$2(this), 62, (Object) null);
        getViews().getGuildCreateIconUploader().setOnClickListener(new WidgetGuildCreate$onResume$3(this));
        b.n(getViews().getGuidelinesTextView(), 2131888247, new Object[]{GUIDELINES_URL}, null, 4);
        EditText editText = getViews().getGuildCreateName().getEditText();
        if (editText != null) {
            TextWatcherKt.addLifecycleAwareTextWatcher(editText, this, new WidgetGuildCreate$onResume$4(this));
        }
        getViews().getGuildCreateButton().setOnClickListener(new WidgetGuildCreate$onResume$5(this));
    }

    public /* synthetic */ WidgetGuildCreate(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R$layout.widget_guild_create : i);
    }
}
