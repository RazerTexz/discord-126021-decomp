package com.discord.models.domain;

import java.io.IOException;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class ModelVoiceRegion implements Model {
    private boolean deprecated;
    private boolean hidden;

    /* JADX INFO: renamed from: id */
    private String f18585id;
    private String name;
    private boolean optimal;
    private String sampleHostname;
    private int samplePort;

    @Override // com.discord.models.domain.Model
    public void assignField(Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "deprecated":
                this.deprecated = jsonReader.nextBoolean(this.deprecated);
                break;
            case "optimal":
                this.optimal = jsonReader.nextBoolean(this.optimal);
                break;
            case "hidden":
                this.hidden = jsonReader.nextBoolean(this.hidden);
                break;
            case "id":
                this.f18585id = jsonReader.nextString(this.f18585id);
                break;
            case "name":
                this.name = jsonReader.nextString(this.name);
                break;
            case "sample_hostname":
                this.sampleHostname = jsonReader.nextString(this.sampleHostname);
                break;
            case "sample_port":
                this.samplePort = jsonReader.nextInt(this.samplePort);
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelVoiceRegion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelVoiceRegion)) {
            return false;
        }
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) obj;
        if (!modelVoiceRegion.canEqual(this) || isOptimal() != modelVoiceRegion.isOptimal() || getSamplePort() != modelVoiceRegion.getSamplePort() || isDeprecated() != modelVoiceRegion.isDeprecated() || isHidden() != modelVoiceRegion.isHidden()) {
            return false;
        }
        String id2 = getId();
        String id3 = modelVoiceRegion.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String name = getName();
        String name2 = modelVoiceRegion.getName();
        if (name != null ? !name.equals(name2) : name2 != null) {
            return false;
        }
        String sampleHostname = getSampleHostname();
        String sampleHostname2 = modelVoiceRegion.getSampleHostname();
        return sampleHostname != null ? sampleHostname.equals(sampleHostname2) : sampleHostname2 == null;
    }

    public String getId() {
        return this.f18585id;
    }

    public String getName() {
        return this.name;
    }

    public String getSampleHostname() {
        return this.sampleHostname;
    }

    public int getSamplePort() {
        return this.samplePort;
    }

    public int hashCode() {
        int samplePort = (((getSamplePort() + (((isOptimal() ? 79 : 97) + 59) * 59)) * 59) + (isDeprecated() ? 79 : 97)) * 59;
        int i = isHidden() ? 79 : 97;
        String id2 = getId();
        int iHashCode = ((samplePort + i) * 59) + (id2 == null ? 43 : id2.hashCode());
        String name = getName();
        int iHashCode2 = (iHashCode * 59) + (name == null ? 43 : name.hashCode());
        String sampleHostname = getSampleHostname();
        return (iHashCode2 * 59) + (sampleHostname != null ? sampleHostname.hashCode() : 43);
    }

    public boolean isDeprecated() {
        return this.deprecated;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isOptimal() {
        return this.optimal;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelVoiceRegion(id=");
        sbM833U.append(getId());
        sbM833U.append(", name=");
        sbM833U.append(getName());
        sbM833U.append(", optimal=");
        sbM833U.append(isOptimal());
        sbM833U.append(", samplePort=");
        sbM833U.append(getSamplePort());
        sbM833U.append(", sampleHostname=");
        sbM833U.append(getSampleHostname());
        sbM833U.append(", deprecated=");
        sbM833U.append(isDeprecated());
        sbM833U.append(", hidden=");
        sbM833U.append(isHidden());
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
