package com.discord.widgets.nux;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildTemplateViewType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TEMPLATE = 1;
    private static final int TEXT = 0;
    private final int viewType;

    /* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int getTEMPLATE() {
            return GuildTemplateViewType.TEMPLATE;
        }

        public final int getTEXT() {
            return GuildTemplateViewType.TEXT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
    public static final /* data */ class Template extends GuildTemplateViewType {
        private final GuildTemplate guildTemplate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Template(GuildTemplate guildTemplate) {
            super(GuildTemplateViewType.INSTANCE.getTEMPLATE(), null);
            C12238m.checkNotNullParameter(guildTemplate, "guildTemplate");
            this.guildTemplate = guildTemplate;
        }

        public static /* synthetic */ Template copy$default(Template template, GuildTemplate guildTemplate, int i, Object obj) {
            if ((i & 1) != 0) {
                guildTemplate = template.guildTemplate;
            }
            return template.copy(guildTemplate);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildTemplate getGuildTemplate() {
            return this.guildTemplate;
        }

        public final Template copy(GuildTemplate guildTemplate) {
            C12238m.checkNotNullParameter(guildTemplate, "guildTemplate");
            return new Template(guildTemplate);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Template) && C12238m.areEqual(this.guildTemplate, ((Template) other).guildTemplate);
            }
            return true;
        }

        public final GuildTemplate getGuildTemplate() {
            return this.guildTemplate;
        }

        public int hashCode() {
            GuildTemplate guildTemplate = this.guildTemplate;
            if (guildTemplate != null) {
                return guildTemplate.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Template(guildTemplate=");
            sbM833U.append(this.guildTemplate);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
    public static final class Text extends GuildTemplateViewType {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(GuildTemplateViewType.INSTANCE.getTEXT(), null);
        }
    }

    private GuildTemplateViewType(int i) {
        this.viewType = i;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ GuildTemplateViewType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
