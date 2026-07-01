package com.discord.widgets.share;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.c;
import b.a.a.c$b;
import b.a.d.j;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetIncomingShareBinding;
import com.discord.stores.StoreGuilds$Actions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.SendUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemChannel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemGuild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemUser;
import com.google.android.material.textfield.TextInputLayout;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Attachment$Companion;
import d0.g0.t;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Observable$c;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetIncomingShare.class, "binding", "getBinding()Lcom/discord/databinding/WidgetIncomingShareBinding;", 0)};
    public static final WidgetIncomingShare$Companion Companion = new WidgetIncomingShare$Companion(null);
    private static final String EXTRA_RECIPIENT = "EXTRA_RECIPIENT";
    private static final int FLIPPER_RESULTS = 0;
    private static final int FLIPPER_RESULTS_EMPTY = 1;
    private static final int FLIPPER_SEARCH = 0;
    private static final int FLIPPER_SELECTED = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> commentPublisher;
    private final BehaviorSubject<WidgetIncomingShare$ContentModel> contentPublisher;
    private WidgetIncomingShare$Adapter previewAdapter;
    private String queryString;
    private WidgetGlobalSearchAdapter resultsAdapter;
    private final BehaviorSubject<String> searchQueryPublisher;
    private final BehaviorSubject<WidgetGlobalSearchModel$ItemDataPayload> selectedReceiverPublisher;

    public WidgetIncomingShare() {
        super(R$layout.widget_incoming_share);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetIncomingShare$binding$2.INSTANCE, null, 2, null);
        this.contentPublisher = BehaviorSubject.k0();
        this.commentPublisher = BehaviorSubject.l0("");
        this.searchQueryPublisher = BehaviorSubject.l0("");
        this.selectedReceiverPublisher = BehaviorSubject.k0();
    }

    public static final /* synthetic */ void access$configureUi(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$Model widgetIncomingShare$Model, Clock clock) {
        widgetIncomingShare.configureUi(widgetIncomingShare$Model, clock);
    }

    public static final /* synthetic */ WidgetIncomingShareBinding access$getBinding$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.getBinding();
    }

    public static final /* synthetic */ BehaviorSubject access$getCommentPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.commentPublisher;
    }

    public static final /* synthetic */ BehaviorSubject access$getContentPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.contentPublisher;
    }

    public static final /* synthetic */ String access$getQueryString$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.queryString;
    }

    public static final /* synthetic */ BehaviorSubject access$getSearchQueryPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.searchQueryPublisher;
    }

    public static final /* synthetic */ BehaviorSubject access$getSelectedReceiverPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.selectedReceiverPublisher;
    }

    public static final /* synthetic */ void access$initialize(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel) {
        widgetIncomingShare.initialize(widgetIncomingShare$ContentModel);
    }

    public static final /* synthetic */ void access$onSendClicked(WidgetIncomingShare widgetIncomingShare, Context context, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, boolean z2, int i, boolean z3, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetIncomingShare.onSendClicked(context, widgetGlobalSearchModel$ItemDataPayload, viewEmbedGameInvite$Model, widgetIncomingShare$ContentModel, z2, i, z3, captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ void access$onSendCompleted(WidgetIncomingShare widgetIncomingShare) {
        widgetIncomingShare.onSendCompleted();
    }

    public static final /* synthetic */ void access$setQueryString$p(WidgetIncomingShare widgetIncomingShare, String str) {
        widgetIncomingShare.queryString = str;
    }

    private final void configureAdapter(WidgetIncomingShare$Adapter previewAdapter) {
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.externalShareList");
        recyclerView.setAdapter(previewAdapter);
        ViewCompat.setNestedScrollingEnabled(getBinding().e, false);
        getBinding().e.setHasFixedSize(true);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        getBinding().e.addItemDecoration(new PaddedItemDecorator(0, iDpToPixels, iDpToPixels, false, 8, null));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void configureUi(WidgetIncomingShare$Model widgetIncomingShare$Model, Clock clock) {
        List<Uri> uris;
        configureUi(widgetIncomingShare$Model.getContentModel());
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
        ViewExtensions.setOnEditorActionListener(textInputLayout, new WidgetIncomingShare$configureUi$1(this, widgetIncomingShare$Model));
        if (widgetIncomingShare$Model.getReceiver() != null) {
            AppViewFlipper appViewFlipper = getBinding().k;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.searchFlipper");
            appViewFlipper.setDisplayedChild(1);
            TextInputLayout textInputLayout2 = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.externalShareSearch");
            textInputLayout2.setFocusable(false);
            TextInputLayout textInputLayout3 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.externalShareComment");
            EditText editText = textInputLayout3.getEditText();
            if (editText != null) {
                editText.setImeOptions(4);
            }
            String comment = widgetIncomingShare$Model.getComment();
            setActionBarOptionsMenu(!(comment == null || t.isBlank(comment)) || (((uris = widgetIncomingShare$Model.getContentModel().getUris()) != null && !uris.isEmpty()) || widgetIncomingShare$Model.getGameInviteModel() != null) ? R$menu.menu_external_share : R$menu.menu_empty, new WidgetIncomingShare$configureUi$2(this, widgetIncomingShare$Model), null);
            WidgetGlobalSearchModel$ItemDataPayload receiver = widgetIncomingShare$Model.getReceiver();
            if (receiver instanceof WidgetGlobalSearchModel$ItemUser) {
                getBinding().l.onConfigure((WidgetGlobalSearchModel$ItemUser) widgetIncomingShare$Model.getReceiver());
            } else if (receiver instanceof WidgetGlobalSearchModel$ItemChannel) {
                getBinding().l.onConfigure((WidgetGlobalSearchModel$ItemChannel) widgetIncomingShare$Model.getReceiver());
            } else if (receiver instanceof WidgetGlobalSearchModel$ItemGuild) {
                getBinding().l.onConfigure((WidgetGlobalSearchModel$ItemGuild) widgetIncomingShare$Model.getReceiver());
            }
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().k;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.searchFlipper");
            appViewFlipper2.setDisplayedChild(0);
            TextInputLayout textInputLayout4 = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout4, "binding.externalShareSearch");
            textInputLayout4.setFocusable(true);
            TextInputLayout textInputLayout5 = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.externalShareSearch");
            textInputLayout5.setFocusableInTouchMode(true);
            TextInputLayout textInputLayout6 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout6, "binding.externalShareComment");
            EditText editText2 = textInputLayout6.getEditText();
            if (editText2 != null) {
                editText2.setImeOptions(5);
            }
            AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_empty, null, null, 4, null);
        }
        AppViewFlipper appViewFlipper3 = getBinding().i;
        m.checkNotNullExpressionValue(appViewFlipper3, "binding.incomingShareResultsFlipper");
        appViewFlipper3.setDisplayedChild(widgetIncomingShare$Model.getSearchModel().getData().isEmpty() ? 1 : 0);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetGlobalSearchAdapter.setOnUpdated(new WidgetIncomingShare$configureUi$$inlined$apply$lambda$1(this, widgetIncomingShare$Model));
        List<WidgetGlobalSearchModel$ItemDataPayload> data = widgetIncomingShare$Model.getSearchModel().getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            String key = ((WidgetGlobalSearchModel$ItemDataPayload) obj).getKey();
            WidgetGlobalSearchModel$ItemDataPayload receiver2 = widgetIncomingShare$Model.getReceiver();
            if (!m.areEqual(key, receiver2 != null ? receiver2.getKey() : null)) {
                arrayList.add(obj);
            }
        }
        widgetGlobalSearchAdapter.setData(arrayList);
        widgetGlobalSearchAdapter.setOnSelectedListener(new WidgetIncomingShare$configureUi$$inlined$apply$lambda$2(this, widgetIncomingShare$Model));
        ViewEmbedGameInvite viewEmbedGameInvite = getBinding().c;
        m.checkNotNullExpressionValue(viewEmbedGameInvite, "binding.externalShareActivityActionPreview");
        viewEmbedGameInvite.setVisibility(widgetIncomingShare$Model.getGameInviteModel() != null ? 0 : 8);
        ViewEmbedGameInvite$Model gameInviteModel = widgetIncomingShare$Model.getGameInviteModel();
        if (gameInviteModel != null) {
            getBinding().c.bind(gameInviteModel, clock);
        }
    }

    private final void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final WidgetIncomingShareBinding getBinding() {
        return (WidgetIncomingShareBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void initialize(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel) {
        Context context;
        int i = 0;
        if (widgetIncomingShare$ContentModel.getPreselectedRecipientChannel() != null && (context = getContext()) != null) {
            ChannelSelector.Companion.getInstance().findAndSet(context, widgetIncomingShare$ContentModel.getPreselectedRecipientChannel().longValue());
            m.checkNotNullExpressionValue(context, "context");
            j.c(context, false, getMostRecentIntent().setFlags(268468225), 2);
            finish();
        }
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalShareSearch");
        ViewExtensions.setText(textInputLayout, widgetIncomingShare$ContentModel.getRecipient());
        TextInputLayout textInputLayout2 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.externalShareSearch");
        ViewExtensions.setSelectionEnd(textInputLayout2);
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.externalShareComment");
        ViewExtensions.setText(textInputLayout3, widgetIncomingShare$ContentModel.getSharedText());
        this.contentPublisher.onNext(widgetIncomingShare$ContentModel);
        List<Uri> uris = widgetIncomingShare$ContentModel.getUris();
        if (uris != null) {
            for (Object obj : uris) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                Uri uri = (Uri) obj;
                Context context2 = getContext();
                AnalyticsTracker.addAttachment(AnalyticsTracker.ATTACHMENT_SOURCE_SHARE, AttachmentUtilsKt.getMimeType$default(context2 != null ? context2.getContentResolver() : null, uri, null, 4, null), i);
                i = i2;
            }
        }
    }

    private final void onSendClicked(Context context, WidgetGlobalSearchModel$ItemDataPayload receiver, ViewEmbedGameInvite$Model gameInviteModel, WidgetIncomingShare$ContentModel contentModel, boolean isOnCooldown, int maxFileSizeMB, boolean isUserPremium, CaptchaHelper$CaptchaPayload captchaPayload) {
        Observable$c observable$cD;
        List listEmptyList;
        boolean z2;
        boolean z3;
        boolean z4;
        if (isOnCooldown) {
            b.a.d.m.g(context, 2131887611, 0, null, 12);
            return;
        }
        if (receiver instanceof WidgetGlobalSearchModel$ItemChannel) {
            WidgetGlobalSearchModel$ItemChannel widgetGlobalSearchModel$ItemChannel = (WidgetGlobalSearchModel$ItemChannel) receiver;
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), widgetGlobalSearchModel$ItemChannel.getChannel(), null, null, 6, null);
            observable$cD = o.d(new WidgetIncomingShare$onSendClicked$filter$1(receiver), widgetGlobalSearchModel$ItemChannel.getChannel(), 0L, null, 12);
        } else if (receiver instanceof WidgetGlobalSearchModel$ItemUser) {
            ChannelSelector.Companion.getInstance().findAndSetDirectMessage(context, ((WidgetGlobalSearchModel$ItemUser) receiver).getUser().getId());
            observable$cD = o.d(new WidgetIncomingShare$onSendClicked$filter$2(receiver), receiver.getChannel(), 0L, null, 12);
        } else {
            if (!(receiver instanceof WidgetGlobalSearchModel$ItemGuild)) {
                return;
            }
            StoreStream.Companion.getGuildSelected().set(((WidgetGlobalSearchModel$ItemGuild) receiver).getGuild().getId());
            observable$cD = o.d(new WidgetIncomingShare$onSendClicked$filter$3(receiver), receiver.getChannel(), 0L, null, 12);
        }
        List<Uri> uris = contentModel.getUris();
        if (uris != null) {
            listEmptyList = new ArrayList(d0.t.o.collectionSizeOrDefault(uris, 10));
            for (Uri uri : uris) {
                Attachment$Companion attachment$Companion = Attachment.Companion;
                ContentResolver contentResolver = context.getContentResolver();
                m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                listEmptyList.add(attachment$Companion.b(uri, contentResolver));
            }
        } else {
            listEmptyList = n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            Uri uri2 = ((Attachment) it.next()).getUri();
            ContentResolver contentResolver2 = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
            arrayList.add(Float.valueOf(SendUtilsKt.computeFileSizeMegabytes(uri2, contentResolver2)));
        }
        Float fM111maxOrNull = u.m111maxOrNull((Iterable<Float>) arrayList);
        float fFloatValue = fM111maxOrNull != null ? fM111maxOrNull.floatValue() : 0.0f;
        float fSumOfFloat = u.sumOfFloat(arrayList);
        boolean z5 = listEmptyList instanceof Collection;
        if (!z5 || !listEmptyList.isEmpty()) {
            Iterator it2 = listEmptyList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (AttachmentUtilsKt.isImage((Attachment) it2.next(), context.getContentResolver())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (!z5 || !listEmptyList.isEmpty()) {
            Iterator it3 = listEmptyList.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (AttachmentUtilsKt.isVideo((Attachment) it3.next(), context.getContentResolver())) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
        } else {
            z3 = false;
            break;
        }
        if (!z5 || !listEmptyList.isEmpty()) {
            Iterator it4 = listEmptyList.iterator();
            while (true) {
                if (it4.hasNext()) {
                    if (AttachmentUtilsKt.isGif((Attachment) it4.next(), context.getContentResolver())) {
                        z4 = true;
                        break;
                    }
                } else {
                    z4 = false;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        if (fSumOfFloat > ((float) maxFileSizeMB)) {
            c$b c_b = c.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            c_b.a(parentFragmentManager, isUserPremium, maxFileSizeMB, fFloatValue, fSumOfFloat, null, listEmptyList.size(), z2, z3, z4);
            return;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        Observable<R> observableK = storeStream$Companion.getChannelsSelected().observeSelectedChannel().k(observable$cD);
        m.checkNotNullExpressionValue(observableK, "StoreStream\n            …         .compose(filter)");
        Observable observableA = Observable.j(observableObserveMe$default, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableK, 1000L, false, 2, null), WidgetIncomingShare$onSendClicked$1.INSTANCE).Z(1).A(new WidgetIncomingShare$onSendClicked$2(this, listEmptyList, gameInviteModel, captchaPayload));
        m.checkNotNullExpressionValue(observableA, "Observable\n        .comb…ervable.empty()\n        }");
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui(observableA, this, widgetGlobalSearchAdapter), getBinding().f2479b, 0L), WidgetIncomingShare.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetIncomingShare$onSendClicked$3(this, listEmptyList, context, receiver, gameInviteModel, contentModel, isOnCooldown, maxFileSizeMB, isUserPremium, z2, z3, z4), 62, (Object) null);
    }

    public static /* synthetic */ void onSendClicked$default(WidgetIncomingShare widgetIncomingShare, Context context, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, boolean z2, int i, boolean z3, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i2, Object obj) {
        widgetIncomingShare.onSendClicked(context, widgetGlobalSearchModel$ItemDataPayload, viewEmbedGameInvite$Model, widgetIncomingShare$ContentModel, z2, i, z3, (i2 & 128) != 0 ? null : captchaHelper$CaptchaPayload);
    }

    private final void onSendCompleted() {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "this.context ?: return");
            if (!m.areEqual(getMostRecentIntent().getAction(), "com.discord.intent.action.SDK") && getMostRecentIntent().getBooleanExtra("com.discord.intent.extra.EXTRA_CONTINUE_IN_APP", true)) {
                j.c(context, false, new Intent().addFlags(268468224), 2);
            }
            finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Context context = getContext();
        if (context == null) {
            finish();
            return;
        }
        WidgetIncomingShare$Adapter widgetIncomingShare$Adapter = new WidgetIncomingShare$Adapter(this, new WidgetIncomingShare$ContentModel(null, null, null, null, null, null, 63, null), null, 2, null);
        this.previewAdapter = widgetIncomingShare$Adapter;
        if (widgetIncomingShare$Adapter == null) {
            m.throwUninitializedPropertyAccessException("previewAdapter");
        }
        configureAdapter(widgetIncomingShare$Adapter);
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetIncomingShare$onViewBound$1(this));
        RecyclerView recyclerView = getBinding().h;
        m.checkNotNullExpressionValue(recyclerView, "binding.externalShareSearchResults");
        this.resultsAdapter = (WidgetGlobalSearchAdapter) MGRecyclerAdapter.Companion.configure(new WidgetGlobalSearchAdapter(recyclerView));
        ViewCompat.setNestedScrollingEnabled(getBinding().h, false);
        getBinding().h.setHasFixedSize(false);
        TextInputLayout textInputLayout2 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.externalShareSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetIncomingShare$onViewBound$2(this));
        TextInputLayout textInputLayout3 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.externalShareSearch");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout3, new WidgetIncomingShare$onViewBound$3(this));
        getBinding().m.setOnClickListener(new WidgetIncomingShare$onViewBound$4(this));
        this.selectedReceiverPublisher.onNext(null);
        AppViewFlipper appViewFlipper = getBinding().k;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.searchFlipper");
        appViewFlipper.setInAnimation(AnimationUtils.loadAnimation(context, 2130771970));
        AppViewFlipper appViewFlipper2 = getBinding().k;
        m.checkNotNullExpressionValue(appViewFlipper2, "binding.searchFlipper");
        appViewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(context, 2130771973));
        setOnNewIntentListener(new WidgetIncomingShare$onViewBound$5(this));
        initialize(WidgetIncomingShare$ContentModel.Companion.get(getMostRecentIntent()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        BehaviorSubject<String> behaviorSubject = this.searchQueryPublisher;
        m.checkNotNullExpressionValue(behaviorSubject, "searchQueryPublisher");
        StoreGuilds$Actions.requestMembers(this, behaviorSubject, false);
        Clock clock = ClockFactory.get();
        Observable<R> observableY = this.selectedReceiverPublisher.r().Y(new WidgetIncomingShare$onViewBoundOrOnResume$1(this));
        m.checkNotNullExpressionValue(observableY, "selectedReceiverPublishe…  )\n          }\n        }");
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(observableY);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableComputationLatest, this, widgetGlobalSearchAdapter), WidgetIncomingShare.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetIncomingShare$onViewBoundOrOnResume$2(this, clock), 62, (Object) null);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void configureUi(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel) {
        WidgetIncomingShare$Adapter widgetIncomingShare$Adapter = this.previewAdapter;
        if (widgetIncomingShare$Adapter == null) {
            m.throwUninitializedPropertyAccessException("previewAdapter");
        }
        widgetIncomingShare$Adapter.setData(widgetIncomingShare$ContentModel, new WidgetIncomingShare$configureUi$5(this, widgetIncomingShare$ContentModel));
        WidgetIncomingShare$Adapter widgetIncomingShare$Adapter2 = this.previewAdapter;
        if (widgetIncomingShare$Adapter2 == null) {
            m.throwUninitializedPropertyAccessException("previewAdapter");
        }
        widgetIncomingShare$Adapter2.notifyDataSetChanged();
        List<Uri> uris = widgetIncomingShare$ContentModel.getUris();
        boolean z2 = (uris == null || uris.isEmpty()) ? false : true;
        CardView cardView = getBinding().f;
        m.checkNotNullExpressionValue(cardView, "binding.externalShareListWrap");
        cardView.setVisibility(z2 ? 0 : 8);
        getBinding().d.setHint(z2 ? 2131886309 : 2131896642);
    }
}
