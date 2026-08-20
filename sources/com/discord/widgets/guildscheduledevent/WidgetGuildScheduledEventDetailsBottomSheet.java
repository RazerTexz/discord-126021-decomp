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
import com.discord.C5419R;
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
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.DirectoryButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.GuildButtonConfiguration;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.VoiceUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildScheduledEventDetailsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", 0)};

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
            String strM877t = C1643a.m877t("EVENTDETAILS-", guildScheduledEventId);
            notices.requestToShow(new StoreNotices.Notice(strM877t, null, 0L, 0, false, C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new C8857x72336d71(guildScheduledEventId, notices, strM877t), 150, null));
        }

        public final void handleInvalidEvent(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0876m.m169g(context, C5419R.string.inaccessible_channel_link_title, 0, null, 12);
        }

        public final void show(FragmentManager fragmentManager, GuildScheduledEventDetailsArgs args) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = new WidgetGuildScheduledEventDetailsBottomSheet();
            widgetGuildScheduledEventDetailsBottomSheet.setArguments(C1460d.m514e2(args));
            widgetGuildScheduledEventDetailsBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.class.getName());
        }

        public final void showForDirectory(FragmentManager fragmentManager, long guildScheduledEventId, long hubGuildId, long directoryChannelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new GuildScheduledEventDetailsArgs(guildScheduledEventId, Long.valueOf(hubGuildId), Long.valueOf(directoryChannelId), GuildScheduledEventDetailsSource.Directory));
        }

        public final void showForGuild(FragmentManager fragmentManager, long guildScheduledEventId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new GuildScheduledEventDetailsArgs(guildScheduledEventId, null, null, null, 14, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            EventDetailsRsvpUsersFetchState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[EventDetailsRsvpUsersFetchState.LOADING.ordinal()] = 1;
            iArr[EventDetailsRsvpUsersFetchState.EMPTY.ordinal()] = 2;
            iArr[EventDetailsRsvpUsersFetchState.ERROR.ordinal()] = 3;
            iArr[EventDetailsRsvpUsersFetchState.SUCCESS.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureSegmentControl$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class C88591 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C88591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().setSegmentedControlIndex(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class C88604 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ UserGuildMember $creator;

        /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.replacementText = C88604.this.$creator.getNickOrUserName();
                Context context = WidgetGuildScheduledEventDetailsBottomSheet.this.getContext();
                if (context != null) {
                    FontUtils fontUtils = FontUtils.INSTANCE;
                    C12238m.checkNotNullExpressionValue(context, "ctx");
                    Typeface themedFont = fontUtils.getThemedFont(context, C5419R.attr.font_primary_semibold);
                    if (themedFont != null) {
                        hook.styles.add(new TypefaceSpanCompat(themedFont));
                    }
                }
                hook.styles.add(new ForegroundColorSpan(GuildMember.INSTANCE.getColor(C88604.this.$creator.getGuildMember(), ColorCompat.getThemedColor(WidgetGuildScheduledEventDetailsBottomSheet.this.getContext(), C5419R.attr.colorHeaderPrimary))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88604(UserGuildMember userGuildMember) {
            super(1);
            this.$creator = userGuildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("usernameHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final /* synthetic */ class C88721 extends C12236k implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public C88721(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsBottomSheet, WidgetGuildScheduledEventDetailsBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventDetailsBottomSheet) this.receiver).configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class C88731 extends AbstractC12240o implements Function1<Long, Unit> {
        public C88731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetGuildScheduledEventDetailsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventDetailsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.descriptionParser = C12083g.lazy(new WidgetGuildScheduledEventDetailsBottomSheet$descriptionParser$2(this));
        this.locationParser = C12083g.lazy(WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2.INSTANCE);
        this.args = C12083g.lazy(new C8856x82cb5b4e(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsBottomSheet$viewModel$2 widgetGuildScheduledEventDetailsBottomSheet$viewModel$2 = new WidgetGuildScheduledEventDetailsBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new C8858x355f71cf(c0865g0), new C0869i0(widgetGuildScheduledEventDetailsBottomSheet$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsBottomSheet$previewLauncher$1(this));
    }

    private final void configureForRsvpUsersFetchState(EventDetailsRsvpUsersFetchState rsvpUsersFetchState) {
        ProgressBar progressBar = getBinding().f16997s;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.loadingIndicator");
        progressBar.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().f16992n;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().f16996r;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        recyclerView.setVisibility(8);
        int iOrdinal = rsvpUsersFetchState.ordinal();
        if (iOrdinal == 0) {
            ProgressBar progressBar2 = getBinding().f16997s;
            C12238m.checkNotNullExpressionValue(progressBar2, "binding.loadingIndicator");
            progressBar2.setVisibility(0);
            return;
        }
        if (iOrdinal == 1) {
            ConstraintLayout constraintLayout2 = getBinding().f16992n;
            C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventEmptyOrErrorContainer");
            constraintLayout2.setVisibility(0);
            TextView textView = getBinding().f16993o;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventEmptyOrErrorTitle");
            C1107b.m221m(textView, C5419R.string.guild_event_details_user_list_fetch_error, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            RecyclerView recyclerView2 = getBinding().f16996r;
            C12238m.checkNotNullExpressionValue(recyclerView2, "binding.guildScheduledEventRsvpListRecyclerView");
            recyclerView2.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout3 = getBinding().f16992n;
        C12238m.checkNotNullExpressionValue(constraintLayout3, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout3.setVisibility(0);
        TextView textView2 = getBinding().f16993o;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventEmptyOrErrorTitle");
        C1107b.m221m(textView2, C5419R.string.guild_event_details_user_list_empty_title, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void configureForSection(EventDetailsSection section, EventDetailsRsvpUsersFetchState rsvpUsersFetchState) {
        EventDetailsSection eventDetailsSection = EventDetailsSection.RSVP_LIST;
        if (section == eventDetailsSection) {
            configureForRsvpUsersFetchState(rsvpUsersFetchState);
        }
        ConstraintLayout constraintLayout = getBinding().f16994p;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventInfoContainer");
        constraintLayout.setVisibility(section == EventDetailsSection.EVENT_INFO ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().f16995q;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventRsvpListContainer");
        constraintLayout2.setVisibility(section == eventDetailsSection ? 0 : 8);
    }

    private final void configureSegmentControl(int segmentIndex, boolean hide) {
        SegmentedControlContainer segmentedControlContainer = getBinding().f16998t;
        C12238m.checkNotNullExpressionValue(segmentedControlContainer, "binding.segmentedControl");
        segmentedControlContainer.setVisibility(hide ^ true ? 0 : 8);
        if (hide) {
            return;
        }
        SegmentedControlContainer.m8606b(getBinding().f16998t, 0, 1);
        getBinding().f16998t.setOnSegmentSelectedChangeListener(new C88591());
        getBinding().f16998t.setSelectedIndex(segmentIndex);
        CardSegment cardSegment = getBinding().f16999u;
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        cardSegment.setText(C1107b.m216h(contextRequireContext, C5419R.string.guild_event_details_info_tab_title, new Object[0], null, 4));
        CardSegment cardSegment2 = getBinding().f17000v;
        Context contextRequireContext2 = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        cardSegment2.setText(C1107b.m216h(contextRequireContext2, C5419R.string.indicate_rsvp, new Object[0], null, 4));
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
        getBinding().f16985g.configure(initialized.getGuildScheduledEvent(), false);
        TextView textView = getBinding().f16991m;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventDetailsTitleText");
        textView.setText(initialized.getGuildScheduledEvent().getName());
        SimpleDraweeView simpleDraweeView = getBinding().f16987i;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventDetailsGuildIcon");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, initialized.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        TextView textView2 = getBinding().f16988j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventDetailsGuildName");
        textView2.setText(initialized.getGuild().getName());
        GuildScheduledEventLocationInfo locationInfo = initialized.getLocationInfo();
        if (locationInfo != null) {
            getBinding().f16981c.setImageResource(locationInfo.getLocationIcon());
        }
        ImageView imageView = getBinding().f16981c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.guildScheduledEventDetailsChannelIcon");
        imageView.setVisibility(initialized.getLocationInfo() != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().f16982d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsChannelName");
        GuildScheduledEventLocationInfo locationInfo2 = initialized.getLocationInfo();
        CharSequence charSequenceM216h = null;
        if (locationInfo2 != null) {
            GuildScheduledEventExternalLocationParser locationParser = getLocationParser();
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textFromLocation = locationParser.getTextFromLocation(contextRequireContext, locationInfo2);
        } else {
            textFromLocation = null;
        }
        ViewExtensions.setTextAndVisibilityBy(linkifiedTextView, textFromLocation);
        ImageView imageView2 = getBinding().f16990l;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.guildScheduledEventDetailsRsvpIcon");
        imageView2.setVisibility(initialized.getGuildScheduledEvent().getUserCount() != null ? 0 : 8);
        TextView textView3 = getBinding().f16989k;
        C12238m.checkNotNullExpressionValue(textView3, "binding.guildScheduledEventDetailsRsvpCount");
        Integer userCount = initialized.getGuildScheduledEvent().getUserCount();
        if (userCount != null) {
            int iIntValue = userCount.intValue();
            Context contextRequireContext2 = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            Context contextRequireContext3 = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            charSequenceM216h = C1107b.m216h(contextRequireContext2, C5419R.string.guild_event_interested_count, new Object[]{StringResourceUtilsKt.getI18nPluralString(contextRequireContext3, C5419R.plurals.guild_event_interested_count_count, iIntValue, Integer.valueOf(iIntValue))}, null, 4);
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceM216h);
        UserGuildMember creator = initialized.getCreator();
        if (creator != null) {
            TextView textView4 = getBinding().f16983e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.guildScheduledEventDetailsCreatedBy");
            textView4.setVisibility(0);
            SimpleDraweeView simpleDraweeView2 = getBinding().f16984f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView2.setVisibility(0);
            TextView textView5 = getBinding().f16983e;
            C12238m.checkNotNullExpressionValue(textView5, "binding.guildScheduledEventDetailsCreatedBy");
            C1107b.m221m(textView5, C5419R.string.guild_event_created_by_hook, new Object[]{creator.getNickOrUserName()}, new C88604(creator));
            SimpleDraweeView simpleDraweeView3 = getBinding().f16984f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildScheduledEventDetailsCreatorAvatar");
            SimpleDraweeViewExtensionsKt.configureCreator(simpleDraweeView3, creator);
        } else {
            TextView textView6 = getBinding().f16983e;
            C12238m.checkNotNullExpressionValue(textView6, "binding.guildScheduledEventDetailsCreatedBy");
            textView6.setVisibility(8);
            SimpleDraweeView simpleDraweeView4 = getBinding().f16984f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView4.setVisibility(8);
        }
        getDescriptionParser().configureDescription(initialized.getGuildScheduledEvent().getDescription(), initialized.getGuildScheduledEvent().getGuildId());
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = getBinding().f16980b;
        C12238m.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventDetailsButtonView");
        guildScheduledEventBottomButtonView.setVisibility(0);
        getBinding().f16980b.configureForDetails(getButtonConfiguration(initialized));
        getBinding().f16988j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.configureUi.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsBottomSheet.this.getViewModel().onGuildNameClicked();
                WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            }
        });
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        guildScheduledEventRsvpUserListAdapter.setData(initialized.getRsvpUsers());
    }

    private final GuildScheduledEventDetailsArgs getArgs() {
        return (GuildScheduledEventDetailsArgs) this.args.getValue();
    }

    private final ButtonConfiguration getButtonConfiguration(final GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
        if (getArgs().getSource() == GuildScheduledEventDetailsSource.Directory) {
            return new DirectoryButtonConfiguration(initialized.getGuildScheduledEvent(), initialized.isInGuild(), initialized.isRsvped(), true, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet.getButtonConfiguration.1

                /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f27425a;
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
                    directoryUtils.maybeJoinAndGoToGuild(widgetGuildScheduledEventDetailsBottomSheet, guildScheduledEvent, zIsInGuild, jLongValue, channelId != null ? channelId.longValue() : 0L, !initialized.isRsvped() && GuildScheduledEventUtilitiesKt.canRsvp(initialized.getGuildScheduledEvent()), new AnonymousClass1());
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
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, GuildScheduledEventModelKt.toModel(initialized.getGuildScheduledEvent()), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(initialized.getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : WidgetGuildScheduledEventDetailsBottomSheet.this.previewLauncher, (24 & 16) != 0 ? false : false);
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
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
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
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
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
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        return C5419R.layout.widget_guild_scheduled_event_details_bottom_sheet;
    }

    public final GuildScheduledEventDescriptionParser getDescriptionParser() {
        return (GuildScheduledEventDescriptionParser) this.descriptionParser.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventDetailsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88721(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f16996r;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        this.adapter = new GuildScheduledEventRsvpUserListAdapter(recyclerView, new C88731());
        RecyclerView recyclerView2 = getBinding().f16996r;
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventRsvpUserListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
    }
}
