package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.user.User;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ModelUserRelationship implements Model {
    public static final int TYPE_BLOCKED = 2;
    public static final int TYPE_FRIEND = 1;
    public static final int TYPE_INVITE_INCOMING = 3;
    public static final int TYPE_INVITE_OUTGOING = 4;
    public static final int TYPE_NONE = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2735id;
    private int type;
    private User user;
    private Long userId;

    public ModelUserRelationship() {
    }

    public static boolean isType(Integer num, int i) {
        return num != null && num.intValue() == i;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "user_id":
                this.userId = model$JsonReader.nextLongOrNull();
                break;
            case "id":
                this.f2735id = model$JsonReader.nextLong(this.f2735id);
                break;
            case "type":
                this.type = model$JsonReader.nextInt(this.type);
                break;
            case "user":
                this.user = (User) InboundGatewayGsonParser.fromJson(model$JsonReader, User.class);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelUserRelationship;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelUserRelationship)) {
            return false;
        }
        ModelUserRelationship modelUserRelationship = (ModelUserRelationship) obj;
        if (!modelUserRelationship.canEqual(this) || getId() != modelUserRelationship.getId() || getType() != modelUserRelationship.getType()) {
            return false;
        }
        Long userId = getUserId();
        Long userId2 = modelUserRelationship.getUserId();
        if (userId != null ? !userId.equals(userId2) : userId2 != null) {
            return false;
        }
        User user = getUser();
        User user2 = modelUserRelationship.getUser();
        return user != null ? user.equals(user2) : user2 == null;
    }

    public long getId() {
        return this.f2735id;
    }

    public int getType() {
        return this.type;
    }

    public User getUser() {
        return this.user;
    }

    public Long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long id2 = getId();
        int type = getType() + ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59);
        Long userId = getUserId();
        int iHashCode = (type * 59) + (userId == null ? 43 : userId.hashCode());
        User user = getUser();
        return (iHashCode * 59) + (user != null ? user.hashCode() : 43);
    }

    public ModelUserRelationship hydrate(Map<Long, User> map) {
        if (this.userId == null) {
            return this;
        }
        ModelUserRelationship modelUserRelationship = new ModelUserRelationship(this);
        modelUserRelationship.user = map.get(modelUserRelationship.userId);
        modelUserRelationship.userId = null;
        return modelUserRelationship;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelUserRelationship(id=");
        sbU.append(getId());
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(", user=");
        sbU.append(getUser());
        sbU.append(", userId=");
        sbU.append(getUserId());
        sbU.append(")");
        return sbU.toString();
    }

    public ModelUserRelationship(long j, int i, User user, Long l) {
        this.f2735id = j;
        this.type = i;
        this.user = user;
        this.userId = l;
    }

    public static int getType(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public ModelUserRelationship(ModelUserRelationship modelUserRelationship) {
        this(modelUserRelationship.f2735id, modelUserRelationship.type, modelUserRelationship.user, modelUserRelationship.userId);
    }
}
