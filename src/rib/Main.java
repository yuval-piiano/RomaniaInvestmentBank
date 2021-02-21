package rib;

import java.util.Scanner;

import rib.dao.BankAgencyDao;
import rib.dao.ClientDao;
import rib.entity.Address;
import rib.entity.Client;
import rib.service.AddressService;
import rib.service.BankAccountService;
import rib.service.BankAgencyService;
import rib.service.ClientService;

public class Main {

	public static void main(String[] args) throws Exception {
		ClientService clientService = new ClientService();
		BankAgencyService bankAgencyService = new BankAgencyService();
		BankAgencyDao bankAgencyDao = new BankAgencyDao();
		AddressService addressService = new AddressService();
		BankAccountService bankAccountService=new BankAccountService();
		Scanner scanner = new Scanner(System.in);
		Address address = new Address();
		Client client = new Client();
		ClientDao cDao = new ClientDao();
//		Client client=new Client(1, "f1776", "Maniu", "Maricica", "2810310128900", "maricica_maniu@gmail.com","Cluj-Napoca","76", "0712088737");
//		clientService.saveClient(client);
		// System.out.println(clientService.showAllClients());
//		 clientService.saveClient(client);
		// clientService.orderClientsByNoDesc();
		// System.out.println(clientService.showAllClients());
//		System.out.print("Enter the no of address: ");
//		int no=scanner.nextInt();
//		System.out.println(addressService.findAddressByNo(no));

//		System.out.print("Enter the firstname: ");
//		String firstName=scanner.next();
//		System.out.println(clientService.findClientByFirstName(firstName));
		// System.out.println(bankAgencyDao.findByNo(1));
		// System.out.println(clientService.findClientByNo(5));
		// clientService.addClient(clientService.readClient());
		// System.out.print("\nClient adaugat!\n\n");
		 addressService.addAddress(address);
		System.out.print("Introduceti numarul adresei cautate: ");
		int no=scanner.nextInt();
		System.out.println(addressService.findAddressByNo(no));

		// System.out.println(addressService.orderAddressesByCountyDesc());
		// addressService.addAddress(address);
//		int option;
//		System.out.println(clientService.showAllClients());
//		System.out.println(clientService.orderByNoAsc());
		// System.out.println(bankAgencyService.showAllBankAgency());
		// System.out.println(cDao.findById("30s60"));

//		System.out.print("Introduceti username-ul: ");
//		String username=scanner.next();
//		System.out.println(bankAccountService.findPasswordByUsername(username));
	}

}
