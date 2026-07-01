package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelAuditLogEntry$Options implements Model {
    private long channelId;
    private int count;
    private int deleteMemberDays;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2717id;
    private int membersRemoved;
    private String roleName;
    public final /* synthetic */ ModelAuditLogEntry this$0;
    private int type;

    public ModelAuditLogEntry$Options(ModelAuditLogEntry modelAuditLogEntry) {
        this.this$0 = modelAuditLogEntry;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "channel_id":
                this.channelId = model$JsonReader.nextLong(this.channelId);
                break;
            case "members_removed":
                this.membersRemoved = model$JsonReader.nextInt(this.membersRemoved);
                break;
            case "delete_member_days":
                this.deleteMemberDays = model$JsonReader.nextInt(this.deleteMemberDays);
                break;
            case "id":
                this.f2717id = model$JsonReader.nextLong(this.f2717id);
                break;
            case "type":
                this.type = model$JsonReader.nextInt(this.type);
                break;
            case "count":
                this.count = model$JsonReader.nextInt(this.count);
                break;
            case "role_name":
                this.roleName = model$JsonReader.nextString(this.roleName);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelAuditLogEntry$Options;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelAuditLogEntry$Options)) {
            return false;
        }
        ModelAuditLogEntry$Options modelAuditLogEntry$Options = (ModelAuditLogEntry$Options) obj;
        if (!modelAuditLogEntry$Options.canEqual(this) || getCount() != modelAuditLogEntry$Options.getCount() || getChannelId() != modelAuditLogEntry$Options.getChannelId() || getDeleteMemberDays() != modelAuditLogEntry$Options.getDeleteMemberDays() || getMembersRemoved() != modelAuditLogEntry$Options.getMembersRemoved() || getType() != modelAuditLogEntry$Options.getType() || getId() != modelAuditLogEntry$Options.getId()) {
            return false;
        }
        String roleName = getRoleName();
        String roleName2 = modelAuditLogEntry$Options.getRoleName();
        return roleName != null ? roleName.equals(roleName2) : roleName2 == null;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getCount() {
        return this.count;
    }

    public int getDeleteMemberDays() {
        return this.deleteMemberDays;
    }

    public long getId() {
        return this.f2717id;
    }

    public int getMembersRemoved() {
        return this.membersRemoved;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int count = getCount() + 59;
        long channelId = getChannelId();
        int type = getType() + ((getMembersRemoved() + ((getDeleteMemberDays() + (((count * 59) + ((int) (channelId ^ (channelId >>> 32)))) * 59)) * 59)) * 59);
        long id2 = getId();
        String roleName = getRoleName();
        return (((type * 59) + ((int) ((id2 >>> 32) ^ id2))) * 59) + (roleName == null ? 43 : roleName.hashCode());
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelAuditLogEntry.Options(count=");
        sbU.append(getCount());
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(", roleName=");
        sbU.append(getRoleName());
        sbU.append(", deleteMemberDays=");
        sbU.append(getDeleteMemberDays());
        sbU.append(", membersRemoved=");
        sbU.append(getMembersRemoved());
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(", id=");
        sbU.append(getId());
        sbU.append(")");
        return sbU.toString();
    }
}
