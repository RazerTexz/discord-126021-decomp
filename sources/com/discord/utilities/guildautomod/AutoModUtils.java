package com.discord.utilities.guildautomod;

import com.discord.api.message.embed.EmbedField;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AutoModUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoModUtils {
    public static final AutoModUtils INSTANCE = new AutoModUtils();

    private AutoModUtils() {
    }

    public final String getEmbedFieldValue(MessageEmbed messageEmbed, String name) {
        Object next;
        String value;
        Intrinsics3.checkNotNullParameter(messageEmbed, "messageEmbed");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<EmbedField> listD = messageEmbed.d();
        if (listD != null) {
            Iterator<T> it = listD.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics3.areEqual(((EmbedField) next).getName(), name));
            EmbedField embedField = (EmbedField) next;
            if (embedField != null && (value = embedField.getValue()) != null) {
                return value;
            }
        }
        return "";
    }
}
