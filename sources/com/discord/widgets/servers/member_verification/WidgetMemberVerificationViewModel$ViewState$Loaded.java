package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.guild.Guild;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItem;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetMemberVerificationViewModel$ViewState$Loaded extends WidgetMemberVerificationViewModel$ViewState {
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
    private final WidgetMemberVerificationViewModel$VerificationType verificationType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetMemberVerificationViewModel$ViewState$Loaded(boolean z2, boolean z3, boolean z4, WidgetMemberVerificationViewModel$VerificationType widgetMemberVerificationViewModel$VerificationType, boolean z5, List<? extends MemberVerificationItem> list, ModelMemberVerificationForm modelMemberVerificationForm, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z6, boolean z7, boolean z8, Guild guild) {
        super(null);
        m.checkNotNullParameter(list, "formItems");
        m.checkNotNullParameter(map, "channelNames");
        m.checkNotNullParameter(map2, "roles");
        this.isRulesListVisible = z2;
        this.submitting = z3;
        this.disabled = z4;
        this.verificationType = widgetMemberVerificationViewModel$VerificationType;
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
    public static /* synthetic */ WidgetMemberVerificationViewModel$ViewState$Loaded copy$default(WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded, boolean z2, boolean z3, boolean z4, WidgetMemberVerificationViewModel$VerificationType widgetMemberVerificationViewModel$VerificationType, boolean z5, List list, ModelMemberVerificationForm modelMemberVerificationForm, Map map, Map map2, boolean z6, boolean z7, boolean z8, Guild guild, int i, Object obj) {
        return widgetMemberVerificationViewModel$ViewState$Loaded.copy((i & 1) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.isRulesListVisible : z2, (i & 2) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.submitting : z3, (i & 4) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.disabled : z4, (i & 8) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.verificationType : widgetMemberVerificationViewModel$VerificationType, (i & 16) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.needsAdditionalVerification : z5, (i & 32) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.formItems : list, (i & 64) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.form : modelMemberVerificationForm, (i & 128) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.channelNames : map, (i & 256) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.roles : map2, (i & 512) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.allowAnimatedEmojis : z6, (i & 1024) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.isFormValid : z7, (i & 2048) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.isTermsApproved : z8, (i & 4096) != 0 ? widgetMemberVerificationViewModel$ViewState$Loaded.guild : guild);
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
    public final WidgetMemberVerificationViewModel$VerificationType getVerificationType() {
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

    public final WidgetMemberVerificationViewModel$ViewState$Loaded copy(boolean isRulesListVisible, boolean submitting, boolean disabled, WidgetMemberVerificationViewModel$VerificationType verificationType, boolean needsAdditionalVerification, List<? extends MemberVerificationItem> formItems, ModelMemberVerificationForm form, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isFormValid, boolean isTermsApproved, Guild guild) {
        m.checkNotNullParameter(formItems, "formItems");
        m.checkNotNullParameter(channelNames, "channelNames");
        m.checkNotNullParameter(roles, "roles");
        return new WidgetMemberVerificationViewModel$ViewState$Loaded(isRulesListVisible, submitting, disabled, verificationType, needsAdditionalVerification, formItems, form, channelNames, roles, allowAnimatedEmojis, isFormValid, isTermsApproved, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetMemberVerificationViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded = (WidgetMemberVerificationViewModel$ViewState$Loaded) other;
        return this.isRulesListVisible == widgetMemberVerificationViewModel$ViewState$Loaded.isRulesListVisible && this.submitting == widgetMemberVerificationViewModel$ViewState$Loaded.submitting && this.disabled == widgetMemberVerificationViewModel$ViewState$Loaded.disabled && m.areEqual(this.verificationType, widgetMemberVerificationViewModel$ViewState$Loaded.verificationType) && this.needsAdditionalVerification == widgetMemberVerificationViewModel$ViewState$Loaded.needsAdditionalVerification && m.areEqual(this.formItems, widgetMemberVerificationViewModel$ViewState$Loaded.formItems) && m.areEqual(this.form, widgetMemberVerificationViewModel$ViewState$Loaded.form) && m.areEqual(this.channelNames, widgetMemberVerificationViewModel$ViewState$Loaded.channelNames) && m.areEqual(this.roles, widgetMemberVerificationViewModel$ViewState$Loaded.roles) && this.allowAnimatedEmojis == widgetMemberVerificationViewModel$ViewState$Loaded.allowAnimatedEmojis && this.isFormValid == widgetMemberVerificationViewModel$ViewState$Loaded.isFormValid && this.isTermsApproved == widgetMemberVerificationViewModel$ViewState$Loaded.isTermsApproved && m.areEqual(this.guild, widgetMemberVerificationViewModel$ViewState$Loaded.guild);
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

    public final WidgetMemberVerificationViewModel$VerificationType getVerificationType() {
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
        WidgetMemberVerificationViewModel$VerificationType widgetMemberVerificationViewModel$VerificationType = this.verificationType;
        int iHashCode = (i3 + (widgetMemberVerificationViewModel$VerificationType != null ? widgetMemberVerificationViewModel$VerificationType.hashCode() : 0)) * 31;
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
        StringBuilder sbU = a.U("Loaded(isRulesListVisible=");
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
