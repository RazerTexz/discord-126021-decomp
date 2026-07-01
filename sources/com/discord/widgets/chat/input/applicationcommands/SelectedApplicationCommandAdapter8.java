package com.discord.widgets.chat.input.applicationcommands;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandItem, reason: use source file name */
/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter8 implements MGRecyclerDataPayload {
    public static final int TYPE_PARAM = 1;
    public static final int TYPE_SECTION_HEADING = 2;
    public static final int TYPE_TITLE = 0;
    private final Application application;
    private boolean completed;
    private boolean error;
    private final String heading;
    private boolean highlighted;
    private final String key;
    private final ApplicationCommandOption option;
    private final String title;
    private final int type;

    public SelectedApplicationCommandAdapter8() {
        this(null, null, false, false, false, null, null, Opcodes.LAND, null);
    }

    public SelectedApplicationCommandAdapter8(Application application, ApplicationCommandOption applicationCommandOption, boolean z2, boolean z3, boolean z4, String str, String str2) {
        this.application = application;
        this.option = applicationCommandOption;
        this.highlighted = z2;
        this.error = z3;
        this.completed = z4;
        this.title = str;
        this.heading = str2;
        this.type = applicationCommandOption != null ? 1 : str != null ? 0 : 2;
        int type = getType();
        if (type != 0) {
            if (type != 1) {
                str = type != 2 ? "" : str2 != null ? str2 : "heading";
            } else if (applicationCommandOption == null || (str = applicationCommandOption.getName()) == null) {
                str = "option";
            }
        } else if (str == null) {
            str = "title";
        }
        this.key = str;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    public final boolean getError() {
        return this.error;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final boolean getHighlighted() {
        return this.highlighted;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final ApplicationCommandOption getOption() {
        return this.option;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final void setCompleted(boolean z2) {
        this.completed = z2;
    }

    public final void setError(boolean z2) {
        this.error = z2;
    }

    public final void setHighlighted(boolean z2) {
        this.highlighted = z2;
    }

    public /* synthetic */ SelectedApplicationCommandAdapter8(Application application, ApplicationCommandOption applicationCommandOption, boolean z2, boolean z3, boolean z4, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : application, (i & 2) != 0 ? null : applicationCommandOption, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2);
    }
}
