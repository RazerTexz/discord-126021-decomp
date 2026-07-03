package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GlobalRoleAutocompletable extends Autocompletable {
    private final String text;
    private final List<String> textMatchers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy here$delegate = C12083g.lazy(GlobalRoleAutocompletable$Companion$here$2.INSTANCE);
    private static final Lazy everyone$delegate = C12083g.lazy(GlobalRoleAutocompletable$Companion$everyone$2.INSTANCE);

    /* JADX INFO: compiled from: Autocompletable.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GlobalRoleAutocompletable getEveryone() {
            Lazy lazy = GlobalRoleAutocompletable.everyone$delegate;
            Companion companion = GlobalRoleAutocompletable.INSTANCE;
            return (GlobalRoleAutocompletable) lazy.getValue();
        }

        public final GlobalRoleAutocompletable getHere() {
            Lazy lazy = GlobalRoleAutocompletable.here$delegate;
            Companion companion = GlobalRoleAutocompletable.INSTANCE;
            return (GlobalRoleAutocompletable) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalRoleAutocompletable(String str) {
        super(null);
        C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.text = str;
        this.textMatchers = C12145m.listOf(leadingIdentifier().getIdentifier() + str);
    }

    public static /* synthetic */ GlobalRoleAutocompletable copy$default(GlobalRoleAutocompletable globalRoleAutocompletable, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = globalRoleAutocompletable.text;
        }
        return globalRoleAutocompletable.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final GlobalRoleAutocompletable copy(String text) {
        C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new GlobalRoleAutocompletable(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GlobalRoleAutocompletable) && C12238m.areEqual(this.text, ((GlobalRoleAutocompletable) other).text);
        }
        return true;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return leadingIdentifier().getIdentifier() + this.text;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getText() {
        return this.text;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("GlobalRoleAutocompletable(text="), this.text, ")");
    }
}
