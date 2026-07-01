package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GlobalRoleAutocompletable extends Autocompletable {
    private final String text;
    private final List<String> textMatchers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy here$delegate = LazyJVM.lazy(GlobalRoleAutocompletable$Companion$here$2.INSTANCE);
    private static final Lazy everyone$delegate = LazyJVM.lazy(GlobalRoleAutocompletable$Companion$everyone$2.INSTANCE);

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
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.text = str;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + str);
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
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new GlobalRoleAutocompletable(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GlobalRoleAutocompletable) && Intrinsics3.areEqual(this.text, ((GlobalRoleAutocompletable) other).text);
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
        return outline.J(outline.U("GlobalRoleAutocompletable(text="), this.text, ")");
    }
}
