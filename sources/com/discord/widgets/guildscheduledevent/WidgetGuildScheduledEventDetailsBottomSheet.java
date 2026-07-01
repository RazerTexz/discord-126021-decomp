package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsBottomSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.DirectoryButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.GuildButtonConfiguration;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.VoiceUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventDetailsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GuildScheduledEventRsvpUserListAdapter adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: descriptionParser$delegate, reason: from kotlin metadata */
    private final Lazy descriptionParser;

    /* JADX INFO: renamed from: locationParser$delegate, reason: from kotlin metadata */
    private final Lazy locationParser;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(long guildScheduledEventId) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strT = outline.t("EVENTDETAILS-", guildScheduledEventId);
            notices.requestToShow(new StoreNotices.Notice(strT, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildScheduledEventDetailsBottomSheet4(guildScheduledEventId, notices, strT), 150, null));
        }

        public final void handleInvalidEvent(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppToast.g(context, R.string.inaccessible_channel_link_title, 0, null, 12);
        }

        public final void show(FragmentManager fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = new WidgetGuildScheduledEventDetailsBottomSheet();
            widgetGuildScheduledEventDetailsBottomSheet.setArguments(AnimatableValueParser.e2(args));
            widgetGuildScheduledEventDetailsBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.class.getName());
        }

        public final void showForDirectory(FragmentManager fragmentManager, long guildScheduledEventId, long hubGuildId, long directoryChannelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new WidgetGuildScheduledEventDetailsBottomSheet2(guildScheduledEventId, Long.valueOf(hubGuildId), Long.valueOf(directoryChannelId), WidgetGuildScheduledEventDetailsBottomSheet3.Directory));
        }

        public final void showForGuild(FragmentManager fragmentManager, long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new WidgetGuildScheduledEventDetailsBottomSheet2(guildScheduledEventId, null, null, null, 14, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildScheduledEventDetailsViewModel2.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventDetailsViewModel2.LOADING.ordinal()] = 1;
            iArr[GuildScheduledEventDetailsViewModel2.EMPTY.ordinal()] = 2;
            iArr[GuildScheduledEventDetailsViewModel2.ERROR.ordinal()] = 3;
            iArr[GuildScheduledEventDetailsViewModel2.SUCCESS.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureSegmentControl$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().setSegmentedControlIndex(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ UserGuildMember $creator;

        /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.replacementText = AnonymousClass4.this.$creator.getNickOrUserName();
                Context context = WidgetGuildScheduledEventDetailsBottomSheet.this.getContext();
                if (context != null) {
                    FontUtils fontUtils = FontUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "ctx");
                    Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_semibold);
                    if (themedFont != null) {
                        hook.styles.add(new TypefaceSpanCompat(themedFont));
                    }
                }
                hook.styles.add(new ForegroundColorSpan(GuildMember.INSTANCE.getColor(AnonymousClass4.this.$creator.getGuildMember(), ColorCompat.getThemedColor(WidgetGuildScheduledEventDetailsBottomSheet.this.getContext(), R.attr.colorHeaderPrimary))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(UserGuildMember userGuildMember) {
            super(1);
            this.$creator = userGuildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("usernameHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsBottomSheet, WidgetGuildScheduledEventDetailsBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventDetailsBottomSheet) this.receiver).configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetGuildScheduledEventDetailsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventDetailsBottomSheet5.INSTANCE, null, 2, null);
        this.descriptionParser = LazyJVM.lazy(new WidgetGuildScheduledEventDetailsBottomSheet6(this));
        this.locationParser = LazyJVM.lazy(WidgetGuildScheduledEventDetailsBottomSheet7.INSTANCE);
        this.args = LazyJVM.lazy(new WidgetGuildScheduledEventDetailsBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsBottomSheet9 widgetGuildScheduledEventDetailsBottomSheet9 = new WidgetGuildScheduledEventDetailsBottomSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new WidgetGuildScheduledEventDetailsBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventDetailsBottomSheet9));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsBottomSheet8(this));
    }

    private final void configureForRsvpUsersFetchState(GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState) {
        ProgressBar progressBar = getBinding().f2444s;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.loadingIndicator");
        progressBar.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        recyclerView.setVisibility(8);
        int iOrdinal = rsvpUsersFetchState.ordinal();
        if (iOrdinal == 0) {
            ProgressBar progressBar2 = getBinding().f2444s;
            Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.loadingIndicator");
            progressBar2.setVisibility(0);
            return;
        }
        if (iOrdinal == 1) {
            ConstraintLayout constraintLayout2 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventEmptyOrErrorContainer");
            constraintLayout2.setVisibility(0);
            TextView textView = getBinding().o;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventEmptyOrErrorTitle");
            FormatUtils.m(textView, R.string.guild_event_details_user_list_fetch_error, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            RecyclerView recyclerView2 = getBinding().r;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildScheduledEventRsvpListRecyclerView");
            recyclerView2.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout3 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout3.setVisibility(0);
        TextView textView2 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventEmptyOrErrorTitle");
        FormatUtils.m(textView2, R.string.guild_event_details_user_list_empty_title, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void configureForSection(GuildScheduledEventDetailsViewModel3 section, GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState) {
        GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3 = GuildScheduledEventDetailsViewModel3.RSVP_LIST;
        if (section == guildScheduledEventDetailsViewModel3) {
            configureForRsvpUsersFetchState(rsvpUsersFetchState);
        }
        ConstraintLayout constraintLayout = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventInfoContainer");
        constraintLayout.setVisibility(section == GuildScheduledEventDetailsViewModel3.EVENT_INFO ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventRsvpListContainer");
        constraintLayout2.setVisibility(section == guildScheduledEventDetailsViewModel3 ? 0 : 8);
    }

    private final void configureSegmentControl(int segmentIndex, boolean hide) {
        SegmentedControlContainer segmentedControlContainer = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(segmentedControlContainer, "binding.segmentedControl");
        segmentedControlContainer.setVisibility(hide ^ true ? 0 : 8);
        if (hide) {
            return;
        }
        SegmentedControlContainer.b(getBinding().t, 0, 1);
        getBinding().t.setOnSegmentSelectedChangeListener(new AnonymousClass1());
        getBinding().t.setSelectedIndex(segmentIndex);
        CardSegment cardSegment = getBinding().u;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        cardSegment.setText(FormatUtils.b(contextRequireContext, R.string.guild_event_details_info_tab_title, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
        CardSegment cardSegment2 = getBinding().v;
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        cardSegment2.setText(FormatUtils.b(contextRequireContext2, R.string.indicate_rsvp, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
    }

    private final void configureUi(GuildScheduledEventDetailsViewModel.ViewState viewState) {
        CharSequence textFromLocation;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel.ViewState.Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized = (GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState;
        configureSegmentControl(initialized.getSegmentedControlIndex(), !initialized.isInGuild());
        configureForSection(initialized.getSection(), initialized.getRsvpUsersFetchState());
        getBinding().g.configure(initialized.getGuildScheduledEvent(), false);
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventDetailsTitleText");
        textView.setText(initialized.getGuildScheduledEvent().getName());
        SimpleDraweeView simpleDraweeView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventDetailsGuildIcon");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, initialized.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventDetailsGuildName");
        textView2.setText(initialized.getGuild().getName());
        GuildScheduledEventLocationInfo locationInfo = initialized.getLocationInfo();
        if (locationInfo != null) {
            getBinding().c.setImageResource(locationInfo.getLocationIcon());
        }
        ImageView imageView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildScheduledEventDetailsChannelIcon");
        imageView.setVisibility(initialized.getLocationInfo() != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsChannelName");
        GuildScheduledEventLocationInfo locationInfo2 = initialized.getLocationInfo();
        CharSequence charSequenceB = null;
        if (locationInfo2 != null) {
            GuildScheduledEventExternalLocationParser locationParser = getLocationParser();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textFromLocation = locationParser.getTextFromLocation(contextRequireContext, locationInfo2);
        } else {
            textFromLocation = null;
        }
        ViewExtensions.setTextAndVisibilityBy(linkifiedTextView, textFromLocation);
        ImageView imageView2 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildScheduledEventDetailsRsvpIcon");
        imageView2.setVisibility(initialized.getGuildScheduledEvent().getUserCount() != null ? 0 : 8);
        TextView textView3 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildScheduledEventDetailsRsvpCount");
        Integer userCount = initialized.getGuildScheduledEvent().getUserCount();
        if (userCount != null) {
            int iIntValue = userCount.intValue();
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            Context contextRequireContext3 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            charSequenceB = FormatUtils.b(contextRequireContext2, R.string.guild_event_interested_count, new Object[]{StringResourceUtils.getI18nPluralString(contextRequireContext3, R.plurals.guild_event_interested_count_count, iIntValue, Integer.valueOf(iIntValue))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceB);
        UserGuildMember creator = initialized.getCreator();
        if (creator != null) {
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildScheduledEventDetailsCreatedBy");
            textView4.setVisibility(0);
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView2.setVisibility(0);
            TextView textView5 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildScheduledEventDetailsCreatedBy");
            FormatUtils.m(textView5, R.string.guild_event_created_by_hook, new Object[]{creator.getNickOrUserName()}, new AnonymousClass4(creator));
            SimpleDraweeView simpleDraweeView3 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildScheduledEventDetailsCreatorAvatar");
            SimpleDraweeViewExtensions.configureCreator(simpleDraweeView3, creator);
        } else {
            TextView textView6 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.guildScheduledEventDetailsCreatedBy");
            textView6.setVisibility(8);
            SimpleDraweeView simpleDraweeView4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView4.setVisibility(8);
        }
        getDescriptionParser().configureDescription(initialized.getGuildScheduledEvent().getDescription(), initialized.getGuildScheduledEvent().getGuildId());
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = getBinding().f2443b;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventDetailsButtonView");
        guildScheduledEventBottomButtonView.setVisibility(0);
        getBinding().f2443b.configureForDetails(getButtonConfiguration(initialized));
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.configureUi.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().onGuildNameClicked();
                WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            }
        });
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        guildScheduledEventRsvpUserListAdapter.setData(initialized.getRsvpUsers());
    }

    private final WidgetGuildScheduledEventDetailsBottomSheet2 getArgs() {
        return (WidgetGuildScheduledEventDetailsBottomSheet2) this.args.getValue();
    }

    private final ButtonConfiguration getButtonConfiguration(final GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
        if (getArgs().getSource() == WidgetGuildScheduledEventDetailsBottomSheet3.Directory) {
            return new DirectoryButtonConfiguration(initialized.getGuildScheduledEvent(), initialized.isInGuild(), initialized.isRsvped(), true, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.1

                /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
                public static final class C02951 extends Lambda implements Function0<Unit> {
                    public C02951() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().onRsvpButtonClicked();
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
                    WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = WidgetGuildScheduledEventDetailsBottomSheet.this;
                    GuildScheduledEvent guildScheduledEvent = initialized.getGuildScheduledEvent();
                    boolean zIsInGuild = initialized.isInGuild();
                    Long guildId = WidgetGuildScheduledEventDetailsBottomSheet.this.getArgs().getGuildId();
                    long jLongValue = guildId != null ? guildId.longValue() : 0L;
                    Long channelId = WidgetGuildScheduledEventDetailsBottomSheet.this.getArgs().getChannelId();
                    directoryUtils.maybeJoinAndGoToGuild(widgetGuildScheduledEventDetailsBottomSheet, guildScheduledEvent, zIsInGuild, jLongValue, channelId != null ? channelId.longValue() : 0L, !initialized.isRsvped() && GuildScheduledEventUtilities5.canRsvp(initialized.getGuildScheduledEvent()), new C02951());
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().onRsvpButtonClicked();
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
                    WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.this.getArgs());
                }
            });
        }
        GuildScheduledEvent guildScheduledEvent = initialized.getGuildScheduledEvent();
        boolean canStartEvent = initialized.getCanStartEvent();
        boolean canConnect = initialized.getCanConnect();
        boolean zIsConnected = initialized.isConnected();
        boolean zIsInGuild = initialized.isInGuild();
        boolean zIsRsvped = initialized.isRsvped();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, GuildScheduledEventModel2.toModel(initialized.getGuildScheduledEvent()), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(initialized.getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : WidgetGuildScheduledEventDetailsBottomSheet.this.previewLauncher, (24 & 16) != 0 ? false : false);
            }
        };
        return new GuildButtonConfiguration(guildScheduledEvent, true, canStartEvent, zIsConnected, canConnect, zIsInGuild, zIsRsvped, true, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().onRsvpButtonClicked();
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
                Channel channel = initialized.getChannel();
                if (channel != null) {
                    VoiceUtils.handleCallChannel(channel, WidgetGuildScheduledEventDetailsBottomSheet.this);
                }
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.10

            /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildScheduledEventDetailsViewModel viewModel = WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel();
                Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                viewModel.endEventClicked(contextRequireContext, new AnonymousClass1());
            }
        }, onClickListener, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.this.getArgs());
            }
        });
    }

    private final GuildScheduledEventExternalLocationParser getLocationParser() {
        return (GuildScheduledEventExternalLocationParser) this.locationParser.getValue();
    }

    private final GuildScheduledEventDetailsViewModel getViewModel() {
        return (GuildScheduledEventDetailsViewModel) this.viewModel.getValue();
    }

    public final WidgetGuildScheduledEventDetailsBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventDetailsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_details_bottom_sheet;
    }

    public final GuildScheduledEventDescriptionParser getDescriptionParser() {
        return (GuildScheduledEventDescriptionParser) this.descriptionParser.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventDetailsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        this.adapter = new GuildScheduledEventRsvpUserListAdapter(recyclerView, new AnonymousClass1());
        RecyclerView recyclerView2 = getBinding().r;
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventRsvpUserListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
    }
}
