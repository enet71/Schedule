package factory.concreteFactories;

import factory.FactoryDB;
import factory.abstractProducts.Create;
import factory.abstractProducts.Edit;
import factory.abstractProducts.Remove;
import factory.abstractProducts.Select;
import factory.products.couple.CreateCouple;
import factory.products.couple.RemoveCouple;
import factory.products.couple.SelectCouple;

public class FactoryCouple implements FactoryDB{
    public Create tableCreate() {
        return new CreateCouple();
    }

    public Edit tableEdit() {
        return null;
    }

    public Remove tableRemove() {
        return new RemoveCouple();
    }

    public Select tableSelect() {
        return new SelectCouple();
    }
}
