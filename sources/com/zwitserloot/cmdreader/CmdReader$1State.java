package com.zwitserloot.cmdreader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: app.apk:com/zwitserloot/cmdreader/CmdReader$1State.SCL.lombok */
class CmdReader$1State {
    List<ParseItem> used = new ArrayList();
    final /* synthetic */ Object val$obj;
    final /* synthetic */ CmdReader this$0;

    CmdReader$1State(CmdReader cmdReader, Object obj) {
        this.this$0 = cmdReader;
        this.val$obj = obj;
    }

    void handle(ParseItem item, String value) {
        item.set(this.val$obj, value);
        this.used.add(item);
    }

    void finish() throws InvalidCommandLineException {
        checkForGlobalMandatories();
        checkForExcludes();
        checkForRequires();
        checkForMandatoriesIf();
        checkForMandatoriesIfNot();
    }

    private void checkForGlobalMandatories() throws InvalidCommandLineException {
        for (ParseItem item : CmdReader.access$000(this.this$0)) {
            if (item.isMandatory() && !this.used.contains(item)) {
                throw new InvalidCommandLineException("You did not specify mandatory parameter " + item.getFullName());
            }
        }
    }

    private void checkForExcludes() throws InvalidCommandLineException {
        for (ParseItem item : CmdReader.access$000(this.this$0)) {
            if (this.used.contains(item)) {
                for (String n : item.getExcludes()) {
                    for (ParseItem i : CmdReader.access$000(this.this$0)) {
                        if (i.getFullName().equals(n) && this.used.contains(i)) {
                            throw new InvalidCommandLineException("You specified parameter " + i.getFullName() + " which cannot be used together with " + item.getFullName());
                        }
                    }
                }
            }
        }
    }

    private void checkForRequires() throws InvalidCommandLineException {
        for (ParseItem item : CmdReader.access$000(this.this$0)) {
            if (this.used.contains(item)) {
                for (String n : item.getRequires()) {
                    for (ParseItem i : CmdReader.access$000(this.this$0)) {
                        if (i.getFullName().equals(n) && !this.used.contains(i)) {
                            throw new InvalidCommandLineException("You specified parameter " + item.getFullName() + " which requires that you also supply " + i.getFullName());
                        }
                    }
                }
            }
        }
    }

    private void checkForMandatoriesIf() throws InvalidCommandLineException {
        for (ParseItem item : CmdReader.access$000(this.this$0)) {
            if (!this.used.contains(item) && item.getMandatoryIf().size() != 0) {
                for (String n : item.getMandatoryIf()) {
                    for (ParseItem i : CmdReader.access$000(this.this$0)) {
                        if (i.getFullName().equals(n) && this.used.contains(i)) {
                            throw new InvalidCommandLineException("You did not specify parameter " + item.getFullName() + " which is mandatory if you use " + i.getFullName());
                        }
                    }
                }
            }
        }
    }

    private void checkForMandatoriesIfNot() throws InvalidCommandLineException {
        for (ParseItem item : CmdReader.access$000(this.this$0)) {
            if (!this.used.contains(item) && item.getMandatoryIfNot().size() != 0) {
                Iterator<String> it = item.getMandatoryIfNot().iterator();
                while (true) {
                    if (it.hasNext()) {
                        String n = it.next();
                        for (ParseItem i : CmdReader.access$000(this.this$0)) {
                            if (i.getFullName().equals(n) && this.used.contains(i)) {
                                break;
                            }
                        }
                    } else {
                        StringBuilder alternatives = new StringBuilder();
                        if (item.getMandatoryIfNot().size() > 1) {
                            alternatives.append("one of ");
                        }
                        for (String n2 : item.getMandatoryIfNot()) {
                            alternatives.append(n2).append(", ");
                        }
                        alternatives.setLength(alternatives.length() - 2);
                        throw new InvalidCommandLineException("You did not specify parameter " + item.getFullName() + " which is mandatory unless you use " + ((Object) alternatives));
                    }
                }
            }
        }
    }
}
