package co.unicauca.microkernel.plugins.brasil;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 *
 * @author dafer
 */
public class BrasilDeliveryPlugin implements IDeliveryPlugin{

    /**
     * El cálculo de Brasil es de la siguiente forma:
     * 1. Si el peso es superior a 5Kg entonces el costo es 2 veces la distancia en km.
     * 2. Si el peso es inferior a 5 Kg, pero superior a 1 Kg, el costo es 1.5 veces la distancia en km
     * 3. Si el peso es inferior a 1 Kg el costo es fijo de 50 reales
     * 
     * @param delivery envío
     * @return costo del envío
     */
    public double calculateCost(Delivery dlvr) {
        Product product = dlvr.getProduct();
        double weight = product.getWeight();
        double distance = dlvr.getDistance();
        
        double cost;
        
        if(weight >= 5){
            cost = 2 * distance;
        }else if(weight < 5 && weight > 1){
            cost = 1.5 * distance;
        }else{
            cost = 50;
        }
        
        return cost;
    }
}
