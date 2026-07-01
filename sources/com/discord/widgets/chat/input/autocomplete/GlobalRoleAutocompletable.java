package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.g;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GlobalRoleAutocompletable extends Autocompletable {
    private final String text;
    private final List<String> textMatchers;
    public static final GlobalRoleAutocompletable$Companion Companion = new GlobalRoleAutocompletable$Companion(null);
    private static final Lazy here$delegate = g.lazy(GlobalRoleAutocompletable$Companion$here$2.INSTANCE);
    private static final Lazy everyone$delegate = g.lazy(GlobalRoleAutocompletable$Companion$everyone$2.INSTANCE);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalRoleAutocompletable(String str) {
        super(null);
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.text = str;
        this.textMatchers = d0.t.m.listOf(leadingIdentifier().getIdentifier() + str);
    }

    public static final /* synthetic */ Lazy access$getEveryone$cp() {
        return everyone$delegate;
    }

    public static final /* synthetic */ Lazy access$getHere$cp() {
        return here$delegate;
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
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        return new GlobalRoleAutocompletable(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GlobalRoleAutocompletable) && m.areEqual(this.text, ((GlobalRoleAutocompletable) other).text);
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
        return a.J(a.U("GlobalRoleAutocompletable(text="), this.text, ")");
    }
}
