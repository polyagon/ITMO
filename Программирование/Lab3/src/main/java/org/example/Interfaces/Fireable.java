package org.example.Interfaces;

import org.example.Items.AbstractItem;
import org.example.Items.Fire;

public interface Fireable {
    public void lightTheFire(Fire fire);
    public void burn(Fire fire, AbstractItem item);
}
