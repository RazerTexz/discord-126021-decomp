package com.discord.widgets.servers.member_verification;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuildMemberVerificationForm;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItem;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemParagraph;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTerm;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTermsHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTextInput;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func6;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final Map<Integer, Object> formUserInputDataMap;
    private final long guildId;
    private final Guild inviteGuild;
    private final String location;
    private final RestAPI restAPI;
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> rulesParser;

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetMemberVerificationViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(long guildId, final Guild inviteGuild) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableF = Observable.f(companion.getUsers().observeMe(true), companion.getGuilds().observeGuild(guildId), companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), companion.getChannels().observeNames(), companion.getGuilds().observeRoles(guildId), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), new Func6<MeUser, Guild, StoreGuildMemberVerificationForm.MemberVerificationFormData, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, Boolean, StoreState>() { // from class: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$Companion$observeStores$1
                @Override // rx.functions.Func6
                public /* bridge */ /* synthetic */ WidgetMemberVerificationViewModel.StoreState call(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, ? extends String> map, Map<Long, ? extends GuildRole> map2, Boolean bool) {
                    return call2(meUser, guild, memberVerificationFormData, (Map<Long, String>) map, (Map<Long, GuildRole>) map2, bool);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetMemberVerificationViewModel.StoreState call2(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, String> map, Map<Long, GuildRole> map2, Boolean bool) {
                    Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                    if (guild == null) {
                        guild = inviteGuild;
                    }
                    Intrinsics3.checkNotNullExpressionValue(map, "channels");
                    Intrinsics3.checkNotNullExpressionValue(map2, "roles");
                    Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
                    return new WidgetMemberVerificationViewModel.StoreState(meUser, guild, memberVerificationFormData, map, map2, bool.booleanValue());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n            .…          )\n            }");
            return observableF;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
        public static final /* data */ class Success extends Event {
            private final ApplicationStatus applicationStatus;
            private final Long guildId;
            private final String guildName;
            private final String lastSeen;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Long l, String str, ApplicationStatus applicationStatus, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
                this.guildId = l;
                this.guildName = str;
                this.applicationStatus = applicationStatus;
                this.lastSeen = str2;
            }

            public static /* synthetic */ Success copy$default(Success success, Long l, String str, ApplicationStatus applicationStatus, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = success.guildId;
                }
                if ((i & 2) != 0) {
                    str = success.guildName;
                }
                if ((i & 4) != 0) {
                    applicationStatus = success.applicationStatus;
                }
                if ((i & 8) != 0) {
                    str2 = success.lastSeen;
                }
                return success.copy(l, str, applicationStatus, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ApplicationStatus getApplicationStatus() {
                return this.applicationStatus;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getLastSeen() {
                return this.lastSeen;
            }

            public final Success copy(Long guildId, String guildName, ApplicationStatus applicationStatus, String lastSeen) {
                Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
                return new Success(guildId, guildName, applicationStatus, lastSeen);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics3.areEqual(this.guildId, success.guildId) && Intrinsics3.areEqual(this.guildName, success.guildName) && Intrinsics3.areEqual(this.applicationStatus, success.applicationStatus) && Intrinsics3.areEqual(this.lastSeen, success.lastSeen);
            }

            public final ApplicationStatus getApplicationStatus() {
                return this.applicationStatus;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getLastSeen() {
                return this.lastSeen;
            }

            public int hashCode() {
                Long l = this.guildId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                String str = this.guildName;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                ApplicationStatus applicationStatus = this.applicationStatus;
                int iHashCode3 = (iHashCode2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
                String str2 = this.lastSeen;
                return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Success(guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", applicationStatus=");
                sbU.append(this.applicationStatus);
                sbU.append(", lastSeen=");
                return outline.J(sbU, this.lastSeen, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean allowAnimatedEmojis;
        private final Map<Long, String> channels;
        private final Guild guild;
        private final MeUser me;
        private final StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData;
        private final Map<Long, GuildRole> roles;

        public StoreState(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z2) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(map2, "roles");
            this.me = meUser;
            this.guild = guild;
            this.memberVerificationFormData = memberVerificationFormData;
            this.channels = map;
            this.roles = map2;
            this.allowAnimatedEmojis = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map map, Map map2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.me;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                memberVerificationFormData = storeState.memberVerificationFormData;
            }
            StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData2 = memberVerificationFormData;
            if ((i & 8) != 0) {
                map = storeState.channels;
            }
            Map map3 = map;
            if ((i & 16) != 0) {
                map2 = storeState.roles;
            }
            Map map4 = map2;
            if ((i & 32) != 0) {
                z2 = storeState.allowAnimatedEmojis;
            }
            return storeState.copy(meUser, guild2, memberVerificationFormData2, map3, map4, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreGuildMemberVerificationForm.MemberVerificationFormData getMemberVerificationFormData() {
            return this.memberVerificationFormData;
        }

        public final Map<Long, String> component4() {
            return this.channels;
        }

        public final Map<Long, GuildRole> component5() {
            return this.roles;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        public final StoreState copy(MeUser me2, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, String> channels, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            return new StoreState(me2, guild, memberVerificationFormData, channels, roles, allowAnimatedEmojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.memberVerificationFormData, storeState.memberVerificationFormData) && Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.roles, storeState.roles) && this.allowAnimatedEmojis == storeState.allowAnimatedEmojis;
        }

        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        public final Map<Long, String> getChannels() {
            return this.channels;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final StoreGuildMemberVerificationForm.MemberVerificationFormData getMemberVerificationFormData() {
            return this.memberVerificationFormData;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData = this.memberVerificationFormData;
            int iHashCode3 = (iHashCode2 + (memberVerificationFormData != null ? memberVerificationFormData.hashCode() : 0)) * 31;
            Map<Long, String> map = this.channels;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.roles;
            int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.allowAnimatedEmojis;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode5 + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(me=");
            sbU.append(this.me);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", memberVerificationFormData=");
            sbU.append(this.memberVerificationFormData);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", allowAnimatedEmojis=");
            return outline.O(sbU, this.allowAnimatedEmojis, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public enum VerificationType {
        PHONE,
        EMAIL
    }

    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean allowAnimatedEmojis;
            private final Map<Long, String> channelNames;
            private final boolean disabled;
            private final ModelMemberVerificationForm form;
            private final List<MemberVerificationItem> formItems;
            private final Guild guild;
            private final boolean isFormValid;
            private final boolean isRulesListVisible;
            private final boolean isTermsApproved;
            private final boolean needsAdditionalVerification;
            private final Map<Long, GuildRole> roles;
            private final boolean submitting;
            private final VerificationType verificationType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(boolean z2, boolean z3, boolean z4, VerificationType verificationType, boolean z5, List<? extends MemberVerificationItem> list, ModelMemberVerificationForm modelMemberVerificationForm, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z6, boolean z7, boolean z8, Guild guild) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "formItems");
                Intrinsics3.checkNotNullParameter(map, "channelNames");
                Intrinsics3.checkNotNullParameter(map2, "roles");
                this.isRulesListVisible = z2;
                this.submitting = z3;
                this.disabled = z4;
                this.verificationType = verificationType;
                this.needsAdditionalVerification = z5;
                this.formItems = list;
                this.form = modelMemberVerificationForm;
                this.channelNames = map;
                this.roles = map2;
                this.allowAnimatedEmojis = z6;
                this.isFormValid = z7;
                this.isTermsApproved = z8;
                this.guild = guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, boolean z4, VerificationType verificationType, boolean z5, List list, ModelMemberVerificationForm modelMemberVerificationForm, Map map, Map map2, boolean z6, boolean z7, boolean z8, Guild guild, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.isRulesListVisible : z2, (i & 2) != 0 ? loaded.submitting : z3, (i & 4) != 0 ? loaded.disabled : z4, (i & 8) != 0 ? loaded.verificationType : verificationType, (i & 16) != 0 ? loaded.needsAdditionalVerification : z5, (i & 32) != 0 ? loaded.formItems : list, (i & 64) != 0 ? loaded.form : modelMemberVerificationForm, (i & 128) != 0 ? loaded.channelNames : map, (i & 256) != 0 ? loaded.roles : map2, (i & 512) != 0 ? loaded.allowAnimatedEmojis : z6, (i & 1024) != 0 ? loaded.isFormValid : z7, (i & 2048) != 0 ? loaded.isTermsApproved : z8, (i & 4096) != 0 ? loaded.guild : guild);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsRulesListVisible() {
                return this.isRulesListVisible;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final boolean getIsFormValid() {
                return this.isFormValid;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final boolean getIsTermsApproved() {
                return this.isTermsApproved;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getSubmitting() {
                return this.submitting;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getDisabled() {
                return this.disabled;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final VerificationType getVerificationType() {
                return this.verificationType;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getNeedsAdditionalVerification() {
                return this.needsAdditionalVerification;
            }

            public final List<MemberVerificationItem> component6() {
                return this.formItems;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final ModelMemberVerificationForm getForm() {
                return this.form;
            }

            public final Map<Long, String> component8() {
                return this.channelNames;
            }

            public final Map<Long, GuildRole> component9() {
                return this.roles;
            }

            public final Loaded copy(boolean isRulesListVisible, boolean submitting, boolean disabled, VerificationType verificationType, boolean needsAdditionalVerification, List<? extends MemberVerificationItem> formItems, ModelMemberVerificationForm form, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isFormValid, boolean isTermsApproved, Guild guild) {
                Intrinsics3.checkNotNullParameter(formItems, "formItems");
                Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
                Intrinsics3.checkNotNullParameter(roles, "roles");
                return new Loaded(isRulesListVisible, submitting, disabled, verificationType, needsAdditionalVerification, formItems, form, channelNames, roles, allowAnimatedEmojis, isFormValid, isTermsApproved, guild);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.isRulesListVisible == loaded.isRulesListVisible && this.submitting == loaded.submitting && this.disabled == loaded.disabled && Intrinsics3.areEqual(this.verificationType, loaded.verificationType) && this.needsAdditionalVerification == loaded.needsAdditionalVerification && Intrinsics3.areEqual(this.formItems, loaded.formItems) && Intrinsics3.areEqual(this.form, loaded.form) && Intrinsics3.areEqual(this.channelNames, loaded.channelNames) && Intrinsics3.areEqual(this.roles, loaded.roles) && this.allowAnimatedEmojis == loaded.allowAnimatedEmojis && this.isFormValid == loaded.isFormValid && this.isTermsApproved == loaded.isTermsApproved && Intrinsics3.areEqual(this.guild, loaded.guild);
            }

            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            public final Map<Long, String> getChannelNames() {
                return this.channelNames;
            }

            public final boolean getDisabled() {
                return this.disabled;
            }

            public final ModelMemberVerificationForm getForm() {
                return this.form;
            }

            public final List<MemberVerificationItem> getFormItems() {
                return this.formItems;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getNeedsAdditionalVerification() {
                return this.needsAdditionalVerification;
            }

            public final Map<Long, GuildRole> getRoles() {
                return this.roles;
            }

            public final boolean getSubmitting() {
                return this.submitting;
            }

            public final VerificationType getVerificationType() {
                return this.verificationType;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v26 */
            /* JADX WARN: Type inference failed for: r0v27 */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r0v9, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v22, types: [int] */
            /* JADX WARN: Type inference failed for: r2v24, types: [int] */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v27 */
            /* JADX WARN: Type inference failed for: r2v3, types: [int] */
            /* JADX WARN: Type inference failed for: r2v32 */
            /* JADX WARN: Type inference failed for: r2v34 */
            /* JADX WARN: Type inference failed for: r2v35 */
            /* JADX WARN: Type inference failed for: r2v36 */
            /* JADX WARN: Type inference failed for: r2v37 */
            /* JADX WARN: Type inference failed for: r2v38 */
            /* JADX WARN: Type inference failed for: r2v39 */
            /* JADX WARN: Type inference failed for: r2v40 */
            /* JADX WARN: Type inference failed for: r2v8, types: [int] */
            public int hashCode() {
                boolean z2 = this.isRulesListVisible;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.submitting;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.disabled;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                VerificationType verificationType = this.verificationType;
                int iHashCode = (i3 + (verificationType != null ? verificationType.hashCode() : 0)) * 31;
                boolean z5 = this.needsAdditionalVerification;
                ?? r4 = z5;
                if (z5) {
                    r4 = 1;
                }
                int i4 = (iHashCode + r4) * 31;
                List<MemberVerificationItem> list = this.formItems;
                int iHashCode2 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
                ModelMemberVerificationForm modelMemberVerificationForm = this.form;
                int iHashCode3 = (iHashCode2 + (modelMemberVerificationForm != null ? modelMemberVerificationForm.hashCode() : 0)) * 31;
                Map<Long, String> map = this.channelNames;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map2 = this.roles;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                boolean z6 = this.allowAnimatedEmojis;
                ?? r5 = z6;
                if (z6) {
                    r5 = 1;
                }
                int i5 = (iHashCode5 + r5) * 31;
                boolean z7 = this.isFormValid;
                ?? r6 = z7;
                if (z7) {
                    r6 = 1;
                }
                int i6 = (i5 + r6) * 31;
                boolean z8 = this.isTermsApproved;
                int i7 = (i6 + (z8 ? 1 : z8)) * 31;
                Guild guild = this.guild;
                return i7 + (guild != null ? guild.hashCode() : 0);
            }

            public final boolean isFormValid() {
                return this.isFormValid;
            }

            public final boolean isRulesListVisible() {
                return this.isRulesListVisible;
            }

            public final boolean isTermsApproved() {
                return this.isTermsApproved;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(isRulesListVisible=");
                sbU.append(this.isRulesListVisible);
                sbU.append(", submitting=");
                sbU.append(this.submitting);
                sbU.append(", disabled=");
                sbU.append(this.disabled);
                sbU.append(", verificationType=");
                sbU.append(this.verificationType);
                sbU.append(", needsAdditionalVerification=");
                sbU.append(this.needsAdditionalVerification);
                sbU.append(", formItems=");
                sbU.append(this.formItems);
                sbU.append(", form=");
                sbU.append(this.form);
                sbU.append(", channelNames=");
                sbU.append(this.channelNames);
                sbU.append(", roles=");
                sbU.append(this.roles);
                sbU.append(", allowAnimatedEmojis=");
                sbU.append(this.allowAnimatedEmojis);
                sbU.append(", isFormValid=");
                sbU.append(this.isFormValid);
                sbU.append(", isTermsApproved=");
                sbU.append(this.isTermsApproved);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            StoreGuildMemberVerificationForm.FetchStates.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreGuildMemberVerificationForm.FetchStates.FETCHING.ordinal()] = 1;
            iArr[StoreGuildMemberVerificationForm.FetchStates.SUCCEEDED.ordinal()] = 2;
            iArr[StoreGuildMemberVerificationForm.FetchStates.FAILED.ordinal()] = 3;
            ModelMemberVerificationForm.MemberVerificationFieldType.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.TERMS.ordinal()] = 1;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.TEXT_INPUT.ordinal()] = 2;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.PARAGRAPH.ordinal()] = 3;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.MULTIPLE_CHOICE.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$applyToJoinGuild$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetMemberVerificationViewModel.this.handleGuildUpdateError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$applyToJoinGuild$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public final /* synthetic */ ViewState.Loaded $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ViewState.Loaded loaded) {
            super(1);
            this.$currentViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            Intrinsics3.checkNotNullParameter(modelMemberVerificationFormResponse, "it");
            WidgetMemberVerificationViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$currentViewState, false, false, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            PublishSubject publishSubject = WidgetMemberVerificationViewModel.this.eventSubject;
            Guild guild = this.$currentViewState.getGuild();
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            Guild guild2 = this.$currentViewState.getGuild();
            publishSubject.k.onNext((T) new Event.Success(lValueOf, guild2 != null ? guild2.getName() : null, modelMemberVerificationFormResponse.getApplicationStatus(), modelMemberVerificationFormResponse.getLastSeen()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetMemberVerificationViewModel(long j, String str, Guild guild, StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, RestAPI restAPI, Parser parser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Guild guild2 = (i & 4) != 0 ? null : guild;
        this(j, str, guild2, (i & 8) != 0 ? StoreStream.INSTANCE.getMemberVerificationForms() : storeGuildMemberVerificationForm, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 32) != 0 ? DiscordParser.createParser$default(false, true, false, false, false, 28, null) : parser, (i & 64) != 0 ? INSTANCE.observeStores(j, guild2) : observable);
    }

    private final List<MemberVerificationItem> createFormItems(List<ModelMemberVerificationForm.FormField> formFields, boolean isTermsApproved, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis) {
        if (formFields == null || formFields.isEmpty()) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ModelMemberVerificationForm.FormField formField : formFields) {
            Object obj = this.formUserInputDataMap.get(Integer.valueOf(formFields.indexOf(formField)));
            int iOrdinal = formField.getMemberVerificationFieldType().ordinal();
            if (iOrdinal == 1) {
                List<String> values = formField.getValues();
                if (!values.isEmpty()) {
                    arrayList.add(new MemberVerificationItemTermsHeader());
                    int size = values.size();
                    int i = 0;
                    while (i < size) {
                        int i2 = i + 1;
                        arrayList.add(new MemberVerificationItemTerm(i2, values.get(i), generateAST(values.get(i)), channelNames, roles, allowAnimatedEmojis, i == 0, i == values.size() - 1));
                        i = i2;
                    }
                    arrayList.add(new MemberVerificationItemApproveTerms(formFields.indexOf(formField), isTermsApproved));
                }
            } else if (iOrdinal == 2) {
                arrayList.add(new MemberVerificationItemHeader(formField.getLabel()));
                arrayList.add(new MemberVerificationItemTextInput(formFields.indexOf(formField), (String) obj));
            } else if (iOrdinal == 3) {
                arrayList.add(new MemberVerificationItemHeader(formField.getLabel()));
                arrayList.add(new MemberVerificationItemParagraph(formFields.indexOf(formField), (String) obj));
            } else if (iOrdinal == 4) {
                arrayList.add(new MemberVerificationItemHeader(formField.getLabel()));
                arrayList.add(new MemberVerificationItemMultipleChoice(formFields.indexOf(formField), formField.getChoices(), (Integer) obj));
            }
        }
        return arrayList;
    }

    private final List<Node<MessageRenderContext>> generateAST(CharSequence rawRuleString) {
        return Parser.parse$default(this.rulesParser, rawRuleString, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    @MainThread
    private final void handleGuildUpdateError() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x007e A[PHI: r2
      0x007e: PHI (r2v9 com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$VerificationType) = 
      (r2v8 com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$VerificationType)
      (r2v21 com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$VerificationType)
      (r2v21 com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$VerificationType)
     binds: [B:47:0x008a, B:40:0x0073, B:42:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x008c A[PHI: r2
      0x008c: PHI (r2v20 com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$VerificationType) = 
      (r2v8 com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$VerificationType)
      (r2v21 com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$VerificationType)
     binds: [B:47:0x008a, B:42:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        VerificationType verificationType;
        VerificationType verificationType2;
        boolean z2;
        boolean z3;
        ModelMemberVerificationForm form;
        MeUser me2 = storeState.getMe();
        Guild guild = storeState.getGuild();
        StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData = storeState.getMemberVerificationFormData();
        Map<Long, String> channels = storeState.getChannels();
        Map<Long, GuildRole> roles = storeState.getRoles();
        boolean allowAnimatedEmojis = storeState.getAllowAnimatedEmojis();
        StoreGuildMemberVerificationForm.FetchStates fetchState = memberVerificationFormData != null ? memberVerificationFormData.getFetchState() : null;
        if (fetchState == null) {
            return;
        }
        int iOrdinal = fetchState.ordinal();
        if (iOrdinal == 0) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (iOrdinal == 1) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        ModelMemberVerificationForm form2 = memberVerificationFormData.getForm();
        List<ModelMemberVerificationForm.FormField> formFields = form2 != null ? form2.getFormFields() : null;
        GuildVerificationLevel verificationLevel = guild != null ? guild.getVerificationLevel() : null;
        GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.HIGHEST;
        boolean z4 = verificationLevel != guildVerificationLevel;
        boolean z5 = (guild != null ? guild.getVerificationLevel() : null) == guildVerificationLevel;
        boolean z6 = formFields == null || formFields.isEmpty();
        if (z4) {
            verificationType2 = VerificationType.EMAIL;
            if (me2.isVerified() || UserUtils.INSTANCE.getHasPhone(me2)) {
                verificationType = verificationType2;
                z2 = false;
            } else {
                verificationType = verificationType2;
                z2 = true;
            }
        } else {
            if (z5) {
                verificationType2 = VerificationType.PHONE;
                if (UserUtils.INSTANCE.getHasPhone(me2)) {
                    verificationType = verificationType2;
                } else {
                    verificationType = verificationType2;
                    z2 = true;
                }
            } else {
                verificationType = null;
            }
            z2 = false;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        List<ModelMemberVerificationForm.FormField> formFields2 = (loaded == null || (form = loaded.getForm()) == null) ? null : form.getFormFields();
        if (formFields == null || !(!Intrinsics3.areEqual(formFields2, formFields))) {
            z3 = false;
        } else {
            this.formUserInputDataMap.clear();
            boolean z7 = false;
            int i = 0;
            for (Object obj : formFields) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                if (((ModelMemberVerificationForm.FormField) obj).getMemberVerificationFieldType() != ModelMemberVerificationForm.MemberVerificationFieldType.TERMS) {
                    this.formUserInputDataMap.put(Integer.valueOf(i), null);
                } else {
                    z7 = true;
                }
                i = i2;
            }
            z3 = z7;
        }
        updateViewState(new ViewState.Loaded((formFields == null || formFields.isEmpty()) ? false : true, false, !z6 || z2, verificationType, z2, createFormItems(formFields, !z3, channels, roles, allowAnimatedEmojis), memberVerificationFormData.getForm(), channels, roles, allowAnimatedEmojis, z6 && !z2, !z3, guild));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0039  */
    private final boolean isFormValid() {
        boolean z2;
        Map<Integer, Object> map = this.formUserInputDataMap;
        boolean z3 = false;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<Integer, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if (value != null) {
                    if (value instanceof String) {
                        z2 = ((CharSequence) value).length() == 0;
                    }
                }
                if (z2) {
                    z3 = true;
                    break;
                }
            }
        }
        return !z3;
    }

    public final void applyToJoinGuild() {
        List<ModelMemberVerificationForm.FormField> listEmptyList;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, true, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            ModelMemberVerificationForm form = loaded.getForm();
            if (form == null || (listEmptyList = form.getFormFields()) == null) {
                listEmptyList = Collections2.emptyList();
            }
            for (Map.Entry<Integer, Object> entry : this.formUserInputDataMap.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                Object value = entry.getValue();
                if (value != null) {
                    listEmptyList.get(iIntValue).setResponse(value);
                }
            }
            int i = 0;
            for (Object obj : listEmptyList) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                if (((ModelMemberVerificationForm.FormField) obj).getMemberVerificationFieldType() == ModelMemberVerificationForm.MemberVerificationFieldType.TERMS) {
                    listEmptyList.get(i).setResponse(Boolean.valueOf(loaded.isTermsApproved()));
                }
                i = i2;
            }
            RestAPI restAPI = this.restAPI;
            long j = this.guildId;
            ModelMemberVerificationForm form2 = loaded.getForm();
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.createGuildJoinRequest(j, new RestAPIParams.MemberVerificationForm(listEmptyList, form2 != null ? form2.getVersion() : null)), false, 1, null), this, null, 2, null), (Class<?>) WidgetMemberVerificationViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4(loaded));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        AnalyticsTracker.INSTANCE.dismissModal("Membership Gating", this.location, "dismissed", Long.valueOf(this.guildId));
    }

    public final void updateFormValidation(int key, Object value) {
        boolean zIsFormValid;
        this.formUserInputDataMap.put(Integer.valueOf(key), value);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || loaded.isFormValid() == (zIsFormValid = isFormValid())) {
            return;
        }
        boolean zIsTermsApproved = loaded.isTermsApproved();
        ModelMemberVerificationForm form = loaded.getForm();
        updateViewState(ViewState.Loaded.copy$default(loaded, false, false, (zIsFormValid && zIsTermsApproved && !loaded.getNeedsAdditionalVerification()) ? false : true, null, false, createFormItems(form != null ? form.getFormFields() : null, zIsTermsApproved, loaded.getChannelNames(), loaded.getRoles(), loaded.getAllowAnimatedEmojis()), null, null, null, false, zIsFormValid, false, null, 7131, null));
    }

    public final void updateTermsApproval(boolean isTermsApproved) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            boolean zIsFormValid = isFormValid();
            ModelMemberVerificationForm form = loaded.getForm();
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, (zIsFormValid && isTermsApproved && !loaded.getNeedsAdditionalVerification()) ? false : true, null, false, createFormItems(form != null ? form.getFormFields() : null, isTermsApproved, loaded.getChannelNames(), loaded.getRoles(), loaded.getAllowAnimatedEmojis()), null, null, null, false, zIsFormValid, isTermsApproved, null, 5083, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerificationViewModel(long j, String str, Guild guild, StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, RestAPI restAPI, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(storeGuildMemberVerificationForm, "storeGuildMemberVerificationForm");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(parser, "rulesParser");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.location = str;
        this.inviteGuild = guild;
        this.restAPI = restAPI;
        this.rulesParser = parser;
        this.eventSubject = PublishSubject.k0();
        this.formUserInputDataMap = new HashMap();
        AnalyticsTracker.openModal("Membership Gating", str, Long.valueOf(j));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetMemberVerificationViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        storeGuildMemberVerificationForm.fetchMemberVerificationForm(j);
    }
}
