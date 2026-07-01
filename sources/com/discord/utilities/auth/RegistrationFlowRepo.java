package com.discord.utilities.auth;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.g;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: compiled from: RegistrationFlowRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RegistrationFlowRepo {
    public static final RegistrationFlowRepo$Companion Companion = new RegistrationFlowRepo$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(RegistrationFlowRepo$Companion$INSTANCE$2.INSTANCE);
    private Long birthday;
    private String email;
    private Map<String, ? extends List<String>> errors;
    private ModelInvite invite;
    private boolean isRegistering;
    private String phone;
    private String phoneToken;
    private String username = "";
    private String password = "";

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackTransition$default(RegistrationFlowRepo registrationFlowRepo, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        registrationFlowRepo.trackTransition(str, str2, list);
    }

    public final void clear() {
        this.email = null;
        this.phone = null;
        this.phoneToken = null;
        this.username = "";
        this.password = "";
        this.birthday = null;
        this.errors = null;
    }

    public final Long getBirthday() {
        return this.birthday;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Map<String, List<String>> getErrors() {
        return this.errors;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPhoneToken() {
        return this.phoneToken;
    }

    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: isRegistering, reason: from getter */
    public final boolean getIsRegistering() {
        return this.isRegistering;
    }

    public final void setBirthday(Long l) {
        this.birthday = l;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setErrors(Map<String, ? extends List<String>> map) {
        this.errors = map;
    }

    public final void setInvite(ModelInvite modelInvite) {
        this.invite = modelInvite;
    }

    public final void setPassword(String str) {
        m.checkNotNullParameter(str, "<set-?>");
        this.password = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setPhoneToken(String str) {
        this.phoneToken = str;
    }

    public final void setRegistering(boolean z2) {
        this.isRegistering = z2;
    }

    public final void setUsername(String str) {
        m.checkNotNullParameter(str, "<set-?>");
        this.username = str;
    }

    public final void trackTransition(String step, String actionType, List<String> details) {
        m.checkNotNullParameter(step, "step");
        m.checkNotNullParameter(actionType, "actionType");
        if (this.isRegistering) {
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Map<String, Object> mapModelInviteToProperties = analyticsTracker.modelInviteToProperties(this.invite, new LinkedHashMap());
            if (this.invite != null) {
                mapModelInviteToProperties.put("registration_source", "invite");
            }
            String str = null;
            if (this.email != null) {
                str = NotificationCompat.CATEGORY_EMAIL;
            } else if (this.phone != null) {
                str = "phone";
            }
            analyticsTracker.registerTransition(step, actionType, str, details, mapModelInviteToProperties);
        }
    }
}
