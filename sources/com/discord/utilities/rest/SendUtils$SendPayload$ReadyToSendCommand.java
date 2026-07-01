package com.discord.utilities.rest;

import b.d.b.a.a;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SendUtils$SendPayload$ReadyToSendCommand extends SendUtils$SendPayload {
    private final ApplicationCommandLocalSendData command;
    private final List<SendUtils$FileUpload> uploads;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUtils$SendPayload$ReadyToSendCommand(ApplicationCommandLocalSendData applicationCommandLocalSendData, List<SendUtils$FileUpload> list) {
        super(null);
        m.checkNotNullParameter(applicationCommandLocalSendData, "command");
        m.checkNotNullParameter(list, "uploads");
        this.command = applicationCommandLocalSendData;
        this.uploads = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendUtils$SendPayload$ReadyToSendCommand copy$default(SendUtils$SendPayload$ReadyToSendCommand sendUtils$SendPayload$ReadyToSendCommand, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandLocalSendData = sendUtils$SendPayload$ReadyToSendCommand.command;
        }
        if ((i & 2) != 0) {
            list = sendUtils$SendPayload$ReadyToSendCommand.uploads;
        }
        return sendUtils$SendPayload$ReadyToSendCommand.copy(applicationCommandLocalSendData, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ApplicationCommandLocalSendData getCommand() {
        return this.command;
    }

    public final List<SendUtils$FileUpload> component2() {
        return this.uploads;
    }

    public final SendUtils$SendPayload$ReadyToSendCommand copy(ApplicationCommandLocalSendData command, List<SendUtils$FileUpload> uploads) {
        m.checkNotNullParameter(command, "command");
        m.checkNotNullParameter(uploads, "uploads");
        return new SendUtils$SendPayload$ReadyToSendCommand(command, uploads);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendUtils$SendPayload$ReadyToSendCommand)) {
            return false;
        }
        SendUtils$SendPayload$ReadyToSendCommand sendUtils$SendPayload$ReadyToSendCommand = (SendUtils$SendPayload$ReadyToSendCommand) other;
        return m.areEqual(this.command, sendUtils$SendPayload$ReadyToSendCommand.command) && m.areEqual(this.uploads, sendUtils$SendPayload$ReadyToSendCommand.uploads);
    }

    public final ApplicationCommandLocalSendData getCommand() {
        return this.command;
    }

    public final List<SendUtils$FileUpload> getUploads() {
        return this.uploads;
    }

    public int hashCode() {
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.command;
        int iHashCode = (applicationCommandLocalSendData != null ? applicationCommandLocalSendData.hashCode() : 0) * 31;
        List<SendUtils$FileUpload> list = this.uploads;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ReadyToSendCommand(command=");
        sbU.append(this.command);
        sbU.append(", uploads=");
        return a.L(sbU, this.uploads, ")");
    }
}
