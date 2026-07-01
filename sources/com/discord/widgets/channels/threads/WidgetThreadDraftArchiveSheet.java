package com.discord.widgets.channels.threads;

import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadDraftArchiveSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet = new WidgetThreadDraftArchiveSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetThreadDraftArchiveSheet.setArguments(bundle);
            widgetThreadDraftArchiveSheet.show(fragmentManager, WidgetThreadDraftArchiveSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final StoreThreadDraft.ThreadDraftState draftState;
        private final Guild guild;

        /* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getThreadDraft().observeDraftState(), companion.getGuilds().observeGuild(guildId), companion.getChannelsSelected().observeSelectedChannel(), new Func3<StoreThreadDraft.ThreadDraftState, Guild, Channel, Model>() { // from class: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$Model$Companion$get$1
                    @Override // rx.functions.Func3
                    public final WidgetThreadDraftArchiveSheet.Model call(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
                        Intrinsics3.checkNotNullExpressionValue(threadDraftState, "draftState");
                        return new WidgetThreadDraftArchiveSheet.Model(threadDraftState, guild, channel);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…, guild, channel)\n      }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
            Intrinsics3.checkNotNullParameter(threadDraftState, "draftState");
            this.draftState = threadDraftState;
            this.guild = guild;
            this.channel = channel;
        }

        public static /* synthetic */ Model copy$default(Model model, StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                threadDraftState = model.draftState;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                channel = model.channel;
            }
            return model.copy(threadDraftState, guild, channel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreThreadDraft.ThreadDraftState getDraftState() {
            return this.draftState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Model copy(StoreThreadDraft.ThreadDraftState draftState, Guild guild, Channel channel) {
            Intrinsics3.checkNotNullParameter(draftState, "draftState");
            return new Model(draftState, guild, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.draftState, model.draftState) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreThreadDraft.ThreadDraftState getDraftState() {
            return this.draftState;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            StoreThreadDraft.ThreadDraftState threadDraftState = this.draftState;
            int iHashCode = (threadDraftState != null ? threadDraftState.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            return iHashCode2 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(draftState=");
            sbU.append(this.draftState);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet) {
            super(1, widgetThreadDraftArchiveSheet, WidgetThreadDraftArchiveSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetThreadDraftArchiveSheet) this.receiver).configureUI(model);
        }
    }

    public WidgetThreadDraftArchiveSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadDraftArchiveSheet3.INSTANCE, null, 2, null);
    }

    private final void configureUI(Model model) {
        final StoreThreadDraft.ThreadDraftState draftState = model.getDraftState();
        model.getGuild();
        model.getChannel();
        Integer autoArchiveDuration = draftState.getAutoArchiveDuration();
        int iIntValue = autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440;
        new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits.Location.Obj.LIST_ITEM, null, null, 24, null);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadDraftArchiveSheet.this.setAutoArchiveDuration(draftState, 60);
            }
        });
        MaterialRadioButton materialRadioButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(iIntValue == 60);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadDraftArchiveSheet.this.setAutoArchiveDuration(draftState, 1440);
            }
        });
        MaterialRadioButton materialRadioButton2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(iIntValue == 1440);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadDraftArchiveSheet.this.setAutoArchiveDuration(draftState, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
            }
        });
        MaterialRadioButton materialRadioButton3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(iIntValue == 4320);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadDraftArchiveSheet.this.setAutoArchiveDuration(draftState, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
            }
        });
        MaterialRadioButton materialRadioButton4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        materialRadioButton4.setChecked(iIntValue == 10080);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(StoreThreadDraft.ThreadDraftState draftState, int minutes) {
        StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(draftState, false, Integer.valueOf(minutes), null, false, false, 29, null));
        dismiss();
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), (Class<?>) WidgetThreadDraftArchiveSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_thread_archive_actions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
