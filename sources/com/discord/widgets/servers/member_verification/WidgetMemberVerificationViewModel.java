package com.discord.widgets.servers.member_verification;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMemberVerificationForm$FormField;
import com.discord.models.domain.ModelMemberVerificationForm$MemberVerificationFieldType;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$MemberVerificationForm;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuildMemberVerificationForm;
import com.discord.stores.StoreGuildMemberVerificationForm$FetchStates;
import com.discord.stores.StoreGuildMemberVerificationForm$MemberVerificationFormData;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItem;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemParagraph;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTerm;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTermsHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTextInput;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel extends d0<WidgetMemberVerificationViewModel$ViewState> {
    public static final WidgetMemberVerificationViewModel$Companion Companion = new WidgetMemberVerificationViewModel$Companion(null);
    private final PublishSubject<WidgetMemberVerificationViewModel$Event> eventSubject;
    private final Map<Integer, Object> formUserInputDataMap;
    private final long guildId;
    private final Guild inviteGuild;
    private final String location;
    private final RestAPI restAPI;
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> rulesParser;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetMemberVerificationViewModel(long j, String str, Guild guild, StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, RestAPI restAPI, Parser parser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Guild guild2 = (i & 4) != 0 ? null : guild;
        this(j, str, guild2, (i & 8) != 0 ? StoreStream.Companion.getMemberVerificationForms() : storeGuildMemberVerificationForm, (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 32) != 0 ? DiscordParser.createParser$default(false, true, false, false, false, 28, null) : parser, (i & 64) != 0 ? Companion.observeStores(j, guild2) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel) {
        return widgetMemberVerificationViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleGuildUpdateError(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel) {
        widgetMemberVerificationViewModel.handleGuildUpdateError();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel, WidgetMemberVerificationViewModel$StoreState widgetMemberVerificationViewModel$StoreState) {
        widgetMemberVerificationViewModel.handleStoreState(widgetMemberVerificationViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel, WidgetMemberVerificationViewModel$ViewState widgetMemberVerificationViewModel$ViewState) {
        widgetMemberVerificationViewModel.updateViewState(widgetMemberVerificationViewModel$ViewState);
    }

    private final List<MemberVerificationItem> createFormItems(List<ModelMemberVerificationForm$FormField> formFields, boolean isTermsApproved, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis) {
        if (formFields == null || formFields.isEmpty()) {
            return n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ModelMemberVerificationForm$FormField modelMemberVerificationForm$FormField : formFields) {
            Object obj = this.formUserInputDataMap.get(Integer.valueOf(formFields.indexOf(modelMemberVerificationForm$FormField)));
            int iOrdinal = modelMemberVerificationForm$FormField.getMemberVerificationFieldType().ordinal();
            if (iOrdinal == 1) {
                List<String> values = modelMemberVerificationForm$FormField.getValues();
                if (!values.isEmpty()) {
                    arrayList.add(new MemberVerificationItemTermsHeader());
                    int size = values.size();
                    int i = 0;
                    while (i < size) {
                        int i2 = i + 1;
                        arrayList.add(new MemberVerificationItemTerm(i2, values.get(i), generateAST(values.get(i)), channelNames, roles, allowAnimatedEmojis, i == 0, i == values.size() - 1));
                        i = i2;
                    }
                    arrayList.add(new MemberVerificationItemApproveTerms(formFields.indexOf(modelMemberVerificationForm$FormField), isTermsApproved));
                }
            } else if (iOrdinal == 2) {
                arrayList.add(new MemberVerificationItemHeader(modelMemberVerificationForm$FormField.getLabel()));
                arrayList.add(new MemberVerificationItemTextInput(formFields.indexOf(modelMemberVerificationForm$FormField), (String) obj));
            } else if (iOrdinal == 3) {
                arrayList.add(new MemberVerificationItemHeader(modelMemberVerificationForm$FormField.getLabel()));
                arrayList.add(new MemberVerificationItemParagraph(formFields.indexOf(modelMemberVerificationForm$FormField), (String) obj));
            } else if (iOrdinal == 4) {
                arrayList.add(new MemberVerificationItemHeader(modelMemberVerificationForm$FormField.getLabel()));
                arrayList.add(new MemberVerificationItemMultipleChoice(formFields.indexOf(modelMemberVerificationForm$FormField), modelMemberVerificationForm$FormField.getChoices(), (Integer) obj));
            }
        }
        return arrayList;
    }

    private final List<Node<MessageRenderContext>> generateAST(CharSequence rawRuleString) {
        return Parser.parse$default(this.rulesParser, rawRuleString, MessageParseState.Companion.getInitialState(), null, 4, null);
    }

    @MainThread
    private final void handleGuildUpdateError() {
        WidgetMemberVerificationViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetMemberVerificationViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded = (WidgetMemberVerificationViewModel$ViewState$Loaded) viewState;
        if (widgetMemberVerificationViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetMemberVerificationViewModel$ViewState$Loaded.copy$default(widgetMemberVerificationViewModel$ViewState$Loaded, false, false, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            PublishSubject<WidgetMemberVerificationViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(WidgetMemberVerificationViewModel$Event$Error.INSTANCE);
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
    private final void handleStoreState(WidgetMemberVerificationViewModel$StoreState storeState) {
        WidgetMemberVerificationViewModel$VerificationType widgetMemberVerificationViewModel$VerificationType;
        WidgetMemberVerificationViewModel$VerificationType widgetMemberVerificationViewModel$VerificationType2;
        boolean z2;
        boolean z3;
        ModelMemberVerificationForm form;
        MeUser me2 = storeState.getMe();
        Guild guild = storeState.getGuild();
        StoreGuildMemberVerificationForm$MemberVerificationFormData memberVerificationFormData = storeState.getMemberVerificationFormData();
        Map<Long, String> channels = storeState.getChannels();
        Map<Long, GuildRole> roles = storeState.getRoles();
        boolean allowAnimatedEmojis = storeState.getAllowAnimatedEmojis();
        StoreGuildMemberVerificationForm$FetchStates fetchState = memberVerificationFormData != null ? memberVerificationFormData.getFetchState() : null;
        if (fetchState == null) {
            return;
        }
        int iOrdinal = fetchState.ordinal();
        if (iOrdinal == 0) {
            updateViewState(WidgetMemberVerificationViewModel$ViewState$Loading.INSTANCE);
            return;
        }
        if (iOrdinal == 1) {
            updateViewState(WidgetMemberVerificationViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        ModelMemberVerificationForm form2 = memberVerificationFormData.getForm();
        List<ModelMemberVerificationForm$FormField> formFields = form2 != null ? form2.getFormFields() : null;
        GuildVerificationLevel verificationLevel = guild != null ? guild.getVerificationLevel() : null;
        GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.HIGHEST;
        boolean z4 = verificationLevel != guildVerificationLevel;
        boolean z5 = (guild != null ? guild.getVerificationLevel() : null) == guildVerificationLevel;
        boolean z6 = formFields == null || formFields.isEmpty();
        if (z4) {
            widgetMemberVerificationViewModel$VerificationType2 = WidgetMemberVerificationViewModel$VerificationType.EMAIL;
            if (me2.isVerified() || UserUtils.INSTANCE.getHasPhone(me2)) {
                widgetMemberVerificationViewModel$VerificationType = widgetMemberVerificationViewModel$VerificationType2;
                z2 = false;
            } else {
                widgetMemberVerificationViewModel$VerificationType = widgetMemberVerificationViewModel$VerificationType2;
                z2 = true;
            }
        } else {
            if (z5) {
                widgetMemberVerificationViewModel$VerificationType2 = WidgetMemberVerificationViewModel$VerificationType.PHONE;
                if (UserUtils.INSTANCE.getHasPhone(me2)) {
                    widgetMemberVerificationViewModel$VerificationType = widgetMemberVerificationViewModel$VerificationType2;
                } else {
                    widgetMemberVerificationViewModel$VerificationType = widgetMemberVerificationViewModel$VerificationType2;
                    z2 = true;
                }
            } else {
                widgetMemberVerificationViewModel$VerificationType = null;
            }
            z2 = false;
        }
        WidgetMemberVerificationViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetMemberVerificationViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded = (WidgetMemberVerificationViewModel$ViewState$Loaded) viewState;
        List<ModelMemberVerificationForm$FormField> formFields2 = (widgetMemberVerificationViewModel$ViewState$Loaded == null || (form = widgetMemberVerificationViewModel$ViewState$Loaded.getForm()) == null) ? null : form.getFormFields();
        if (formFields == null || !(!m.areEqual(formFields2, formFields))) {
            z3 = false;
        } else {
            this.formUserInputDataMap.clear();
            boolean z7 = false;
            int i = 0;
            for (Object obj : formFields) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                if (((ModelMemberVerificationForm$FormField) obj).getMemberVerificationFieldType() != ModelMemberVerificationForm$MemberVerificationFieldType.TERMS) {
                    this.formUserInputDataMap.put(Integer.valueOf(i), null);
                } else {
                    z7 = true;
                }
                i = i2;
            }
            z3 = z7;
        }
        updateViewState(new WidgetMemberVerificationViewModel$ViewState$Loaded((formFields == null || formFields.isEmpty()) ? false : true, false, !z6 || z2, widgetMemberVerificationViewModel$VerificationType, z2, createFormItems(formFields, !z3, channels, roles, allowAnimatedEmojis), memberVerificationFormData.getForm(), channels, roles, allowAnimatedEmojis, z6 && !z2, !z3, guild));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0039  */
    private final boolean isFormValid() {
        boolean z2;
        Map<Integer, Object> map = this.formUserInputDataMap;
        boolean z3 = false;
        if (!map.isEmpty()) {
            Iterator<Map$Entry<Integer, Object>> it = map.entrySet().iterator();
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
        List<ModelMemberVerificationForm$FormField> listEmptyList;
        WidgetMemberVerificationViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetMemberVerificationViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded = (WidgetMemberVerificationViewModel$ViewState$Loaded) viewState;
        if (widgetMemberVerificationViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetMemberVerificationViewModel$ViewState$Loaded.copy$default(widgetMemberVerificationViewModel$ViewState$Loaded, false, true, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            ModelMemberVerificationForm form = widgetMemberVerificationViewModel$ViewState$Loaded.getForm();
            if (form == null || (listEmptyList = form.getFormFields()) == null) {
                listEmptyList = n.emptyList();
            }
            for (Map$Entry<Integer, Object> map$Entry : this.formUserInputDataMap.entrySet()) {
                int iIntValue = map$Entry.getKey().intValue();
                Object value = map$Entry.getValue();
                if (value != null) {
                    listEmptyList.get(iIntValue).setResponse(value);
                }
            }
            int i = 0;
            for (Object obj : listEmptyList) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                if (((ModelMemberVerificationForm$FormField) obj).getMemberVerificationFieldType() == ModelMemberVerificationForm$MemberVerificationFieldType.TERMS) {
                    listEmptyList.get(i).setResponse(Boolean.valueOf(widgetMemberVerificationViewModel$ViewState$Loaded.isTermsApproved()));
                }
                i = i2;
            }
            RestAPI restAPI = this.restAPI;
            long j = this.guildId;
            ModelMemberVerificationForm form2 = widgetMemberVerificationViewModel$ViewState$Loaded.getForm();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.createGuildJoinRequest(j, new RestAPIParams$MemberVerificationForm(listEmptyList, form2 != null ? form2.getVersion() : null)), false, 1, null), this, null, 2, null), WidgetMemberVerificationViewModel.class, (Context) null, (Function1) null, new WidgetMemberVerificationViewModel$applyToJoinGuild$3(this), (Function0) null, (Function0) null, new WidgetMemberVerificationViewModel$applyToJoinGuild$4(this, widgetMemberVerificationViewModel$ViewState$Loaded), 54, (Object) null);
        }
    }

    public final Observable<WidgetMemberVerificationViewModel$Event> observeEvents() {
        PublishSubject<WidgetMemberVerificationViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        AnalyticsTracker.INSTANCE.dismissModal("Membership Gating", this.location, "dismissed", Long.valueOf(this.guildId));
    }

    public final void updateFormValidation(int key, Object value) {
        boolean zIsFormValid;
        this.formUserInputDataMap.put(Integer.valueOf(key), value);
        WidgetMemberVerificationViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetMemberVerificationViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded = (WidgetMemberVerificationViewModel$ViewState$Loaded) viewState;
        if (widgetMemberVerificationViewModel$ViewState$Loaded == null || widgetMemberVerificationViewModel$ViewState$Loaded.isFormValid() == (zIsFormValid = isFormValid())) {
            return;
        }
        boolean zIsTermsApproved = widgetMemberVerificationViewModel$ViewState$Loaded.isTermsApproved();
        ModelMemberVerificationForm form = widgetMemberVerificationViewModel$ViewState$Loaded.getForm();
        updateViewState(WidgetMemberVerificationViewModel$ViewState$Loaded.copy$default(widgetMemberVerificationViewModel$ViewState$Loaded, false, false, (zIsFormValid && zIsTermsApproved && !widgetMemberVerificationViewModel$ViewState$Loaded.getNeedsAdditionalVerification()) ? false : true, null, false, createFormItems(form != null ? form.getFormFields() : null, zIsTermsApproved, widgetMemberVerificationViewModel$ViewState$Loaded.getChannelNames(), widgetMemberVerificationViewModel$ViewState$Loaded.getRoles(), widgetMemberVerificationViewModel$ViewState$Loaded.getAllowAnimatedEmojis()), null, null, null, false, zIsFormValid, false, null, 7131, null));
    }

    public final void updateTermsApproval(boolean isTermsApproved) {
        WidgetMemberVerificationViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetMemberVerificationViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded = (WidgetMemberVerificationViewModel$ViewState$Loaded) viewState;
        if (widgetMemberVerificationViewModel$ViewState$Loaded != null) {
            boolean zIsFormValid = isFormValid();
            ModelMemberVerificationForm form = widgetMemberVerificationViewModel$ViewState$Loaded.getForm();
            updateViewState(WidgetMemberVerificationViewModel$ViewState$Loaded.copy$default(widgetMemberVerificationViewModel$ViewState$Loaded, false, false, (zIsFormValid && isTermsApproved && !widgetMemberVerificationViewModel$ViewState$Loaded.getNeedsAdditionalVerification()) ? false : true, null, false, createFormItems(form != null ? form.getFormFields() : null, isTermsApproved, widgetMemberVerificationViewModel$ViewState$Loaded.getChannelNames(), widgetMemberVerificationViewModel$ViewState$Loaded.getRoles(), widgetMemberVerificationViewModel$ViewState$Loaded.getAllowAnimatedEmojis()), null, null, null, false, zIsFormValid, isTermsApproved, null, 5083, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerificationViewModel(long j, String str, Guild guild, StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, RestAPI restAPI, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser, Observable<WidgetMemberVerificationViewModel$StoreState> observable) {
        super(WidgetMemberVerificationViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(storeGuildMemberVerificationForm, "storeGuildMemberVerificationForm");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(parser, "rulesParser");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.location = str;
        this.inviteGuild = guild;
        this.restAPI = restAPI;
        this.rulesParser = parser;
        this.eventSubject = PublishSubject.k0();
        this.formUserInputDataMap = new HashMap();
        AnalyticsTracker.openModal("Membership Gating", str, Long.valueOf(j));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetMemberVerificationViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetMemberVerificationViewModel$1(this), 62, (Object) null);
        storeGuildMemberVerificationForm.fetchMemberVerificationForm(j);
    }
}
