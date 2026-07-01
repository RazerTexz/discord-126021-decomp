package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsBottomSheetBinding;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.DirectoryButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.GuildButtonConfiguration;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventDetailsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", 0)};
    public static final WidgetGuildScheduledEventDetailsBottomSheet$Companion Companion = new WidgetGuildScheduledEventDetailsBottomSheet$Companion(null);
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

    public WidgetGuildScheduledEventDetailsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventDetailsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.descriptionParser = g.lazy(new WidgetGuildScheduledEventDetailsBottomSheet$descriptionParser$2(this));
        this.locationParser = g.lazy(WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2.INSTANCE);
        this.args = g.lazy(new WidgetGuildScheduledEventDetailsBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsBottomSheet$viewModel$2 widgetGuildScheduledEventDetailsBottomSheet$viewModel$2 = new WidgetGuildScheduledEventDetailsBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new WidgetGuildScheduledEventDetailsBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventDetailsBottomSheet$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.Companion.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsBottomSheet$previewLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        widgetGuildScheduledEventDetailsBottomSheet.configureUi(guildScheduledEventDetailsViewModel$ViewState);
    }

    public static final /* synthetic */ GuildScheduledEventDetailsArgs access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getArgs();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventDetailsViewModel access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getViewModel();
    }

    private final void configureForRsvpUsersFetchState(EventDetailsRsvpUsersFetchState rsvpUsersFetchState) {
        ProgressBar progressBar = getBinding().f2444s;
        m.checkNotNullExpressionValue(progressBar, "binding.loadingIndicator");
        progressBar.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().n;
        m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().r;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        recyclerView.setVisibility(8);
        int iOrdinal = rsvpUsersFetchState.ordinal();
        if (iOrdinal == 0) {
            ProgressBar progressBar2 = getBinding().f2444s;
            m.checkNotNullExpressionValue(progressBar2, "binding.loadingIndicator");
            progressBar2.setVisibility(0);
            return;
        }
        if (iOrdinal == 1) {
            ConstraintLayout constraintLayout2 = getBinding().n;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventEmptyOrErrorContainer");
            constraintLayout2.setVisibility(0);
            TextView textView = getBinding().o;
            m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventEmptyOrErrorTitle");
            b.n(textView, 2131890073, new Object[0], null, 4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            RecyclerView recyclerView2 = getBinding().r;
            m.checkNotNullExpressionValue(recyclerView2, "binding.guildScheduledEventRsvpListRecyclerView");
            recyclerView2.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout3 = getBinding().n;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout3.setVisibility(0);
        TextView textView2 = getBinding().o;
        m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventEmptyOrErrorTitle");
        b.n(textView2, 2131890072, new Object[0], null, 4);
    }

    private final void configureForSection(EventDetailsSection section, EventDetailsRsvpUsersFetchState rsvpUsersFetchState) {
        EventDetailsSection eventDetailsSection = EventDetailsSection.RSVP_LIST;
        if (section == eventDetailsSection) {
            configureForRsvpUsersFetchState(rsvpUsersFetchState);
        }
        ConstraintLayout constraintLayout = getBinding().p;
        m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventInfoContainer");
        constraintLayout.setVisibility(section == EventDetailsSection.EVENT_INFO ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().q;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventRsvpListContainer");
        constraintLayout2.setVisibility(section == eventDetailsSection ? 0 : 8);
    }

    private final void configureSegmentControl(int segmentIndex, boolean hide) {
        SegmentedControlContainer segmentedControlContainer = getBinding().t;
        m.checkNotNullExpressionValue(segmentedControlContainer, "binding.segmentedControl");
        segmentedControlContainer.setVisibility(hide ^ true ? 0 : 8);
        if (hide) {
            return;
        }
        SegmentedControlContainer.b(getBinding().t, 0, 1);
        getBinding().t.setOnSegmentSelectedChangeListener(new WidgetGuildScheduledEventDetailsBottomSheet$configureSegmentControl$1(this));
        getBinding().t.setSelectedIndex(segmentIndex);
        CardSegment cardSegment = getBinding().u;
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        cardSegment.setText(b.h(contextRequireContext, 2131890071, new Object[0], null, 4));
        CardSegment cardSegment2 = getBinding().v;
        Context contextRequireContext2 = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        cardSegment2.setText(b.h(contextRequireContext2, 2131892037, new Object[0], null, 4));
    }

    private final void configureUi(GuildScheduledEventDetailsViewModel$ViewState viewState) {
        CharSequence textFromLocation;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        configureSegmentControl(guildScheduledEventDetailsViewModel$ViewState$Initialized.getSegmentedControlIndex(), !guildScheduledEventDetailsViewModel$ViewState$Initialized.isInGuild());
        configureForSection(guildScheduledEventDetailsViewModel$ViewState$Initialized.getSection(), guildScheduledEventDetailsViewModel$ViewState$Initialized.getRsvpUsersFetchState());
        getBinding().g.configure(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent(), false);
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventDetailsTitleText");
        textView.setText(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getName());
        SimpleDraweeView simpleDraweeView = getBinding().i;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventDetailsGuildIcon");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuild(), 0, (MGImages$ChangeDetector) null, false, 28, (Object) null);
        TextView textView2 = getBinding().j;
        m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventDetailsGuildName");
        textView2.setText(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuild().getName());
        GuildScheduledEventLocationInfo locationInfo = guildScheduledEventDetailsViewModel$ViewState$Initialized.getLocationInfo();
        if (locationInfo != null) {
            getBinding().c.setImageResource(locationInfo.getLocationIcon());
        }
        ImageView imageView = getBinding().c;
        m.checkNotNullExpressionValue(imageView, "binding.guildScheduledEventDetailsChannelIcon");
        imageView.setVisibility(guildScheduledEventDetailsViewModel$ViewState$Initialized.getLocationInfo() != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().d;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsChannelName");
        GuildScheduledEventLocationInfo locationInfo2 = guildScheduledEventDetailsViewModel$ViewState$Initialized.getLocationInfo();
        CharSequence charSequenceH = null;
        if (locationInfo2 != null) {
            GuildScheduledEventExternalLocationParser locationParser = getLocationParser();
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textFromLocation = locationParser.getTextFromLocation(contextRequireContext, locationInfo2);
        } else {
            textFromLocation = null;
        }
        ViewExtensions.setTextAndVisibilityBy(linkifiedTextView, textFromLocation);
        ImageView imageView2 = getBinding().l;
        m.checkNotNullExpressionValue(imageView2, "binding.guildScheduledEventDetailsRsvpIcon");
        imageView2.setVisibility(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getUserCount() != null ? 0 : 8);
        TextView textView3 = getBinding().k;
        m.checkNotNullExpressionValue(textView3, "binding.guildScheduledEventDetailsRsvpCount");
        Integer userCount = guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getUserCount();
        if (userCount != null) {
            int iIntValue = userCount.intValue();
            Context contextRequireContext2 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            Context contextRequireContext3 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            charSequenceH = b.h(contextRequireContext2, 2131890085, new Object[]{StringResourceUtilsKt.getI18nPluralString(contextRequireContext3, R$plurals.guild_event_interested_count_count, iIntValue, Integer.valueOf(iIntValue))}, null, 4);
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceH);
        UserGuildMember creator = guildScheduledEventDetailsViewModel$ViewState$Initialized.getCreator();
        if (creator != null) {
            TextView textView4 = getBinding().e;
            m.checkNotNullExpressionValue(textView4, "binding.guildScheduledEventDetailsCreatedBy");
            textView4.setVisibility(0);
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView2.setVisibility(0);
            TextView textView5 = getBinding().e;
            m.checkNotNullExpressionValue(textView5, "binding.guildScheduledEventDetailsCreatedBy");
            b.m(textView5, 2131890065, new Object[]{creator.getNickOrUserName()}, new WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4(this, creator));
            SimpleDraweeView simpleDraweeView3 = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildScheduledEventDetailsCreatorAvatar");
            SimpleDraweeViewExtensionsKt.configureCreator(simpleDraweeView3, creator);
        } else {
            TextView textView6 = getBinding().e;
            m.checkNotNullExpressionValue(textView6, "binding.guildScheduledEventDetailsCreatedBy");
            textView6.setVisibility(8);
            SimpleDraweeView simpleDraweeView4 = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView4.setVisibility(8);
        }
        getDescriptionParser().configureDescription(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getDescription(), guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getGuildId());
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = getBinding().f2443b;
        m.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventDetailsButtonView");
        guildScheduledEventBottomButtonView.setVisibility(0);
        getBinding().f2443b.configureForDetails(getButtonConfiguration(guildScheduledEventDetailsViewModel$ViewState$Initialized));
        getBinding().j.setOnClickListener(new WidgetGuildScheduledEventDetailsBottomSheet$configureUi$5(this));
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        guildScheduledEventRsvpUserListAdapter.setData(guildScheduledEventDetailsViewModel$ViewState$Initialized.getRsvpUsers());
    }

    private final GuildScheduledEventDetailsArgs getArgs() {
        return (GuildScheduledEventDetailsArgs) this.args.getValue();
    }

    private final ButtonConfiguration getButtonConfiguration(GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized) {
        if (getArgs().getSource() == GuildScheduledEventDetailsSource.Directory) {
            return new DirectoryButtonConfiguration(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent(), guildScheduledEventDetailsViewModel$ViewState$Initialized.isInGuild(), guildScheduledEventDetailsViewModel$ViewState$Initialized.isRsvped(), true, new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1(this, guildScheduledEventDetailsViewModel$ViewState$Initialized), new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$2(this), new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$3(this), new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$4(this));
        }
        GuildScheduledEvent guildScheduledEvent = guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent();
        boolean canStartEvent = guildScheduledEventDetailsViewModel$ViewState$Initialized.getCanStartEvent();
        boolean canConnect = guildScheduledEventDetailsViewModel$ViewState$Initialized.getCanConnect();
        boolean zIsConnected = guildScheduledEventDetailsViewModel$ViewState$Initialized.isConnected();
        boolean zIsInGuild = guildScheduledEventDetailsViewModel$ViewState$Initialized.isInGuild();
        boolean zIsRsvped = guildScheduledEventDetailsViewModel$ViewState$Initialized.isRsvped();
        WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5 widgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5 = new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5(this, guildScheduledEventDetailsViewModel$ViewState$Initialized);
        return new GuildButtonConfiguration(guildScheduledEvent, true, canStartEvent, zIsConnected, canConnect, zIsInGuild, zIsRsvped, true, new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$6(this), new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$9(this, guildScheduledEventDetailsViewModel$ViewState$Initialized), new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10(this), widgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5, new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$7(this), new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$8(this));
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
        return R$layout.widget_guild_scheduled_event_details_bottom_sheet;
    }

    public final GuildScheduledEventDescriptionParser getDescriptionParser() {
        return (GuildScheduledEventDescriptionParser) this.descriptionParser.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventDetailsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventDetailsBottomSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().r;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        this.adapter = new GuildScheduledEventRsvpUserListAdapter(recyclerView, new WidgetGuildScheduledEventDetailsBottomSheet$onViewCreated$1(this));
        RecyclerView recyclerView2 = getBinding().r;
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventRsvpUserListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
    }
}
