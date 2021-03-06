package rib;

import java.util.Scanner;

import net.bytebuddy.asm.Advice.This;
import rib.dao.BankAgencyDao;
import rib.dao.ClientDao;
import rib.entity.Address;
import rib.entity.BankAgency;
import rib.entity.Client;
import rib.service.AddressService;
import rib.service.BankAccountService;
import rib.service.BankAgencyService;
import rib.service.ClientService;
import rib.service.CustomerAdvisorsSevice;
import rib.util.HelloUtil;
import rib.util.HibernateUtils;

public class Main {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws Exception {
		CustomerAdvisorsSevice customerAdvisorsSevice = new CustomerAdvisorsSevice();
		ClientDao clientDao = new ClientDao();
		AddressService addressService = new AddressService();
		BankAgencyService bankAgencyService = new BankAgencyService();
		ClientService clientService = new ClientService();
		Address address = new Address();
		Client client = new Client();
		HelloUtil hello = new HelloUtil();
		BankAgency bankAgency = new BankAgency();
		HibernateUtils hibernateUtils = new HibernateUtils();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 for admin, 2 for client");
		int key = scanner.nextInt();

		switch (key) {
		case 1: {
			int option1;
			customerAdvisorsSevice.customerAdvisorsLogin();
			hello.hello();
			do {
				System.out.println("1. Adresa");
				System.out.println("2. Clienti");
				System.out.println("3. Banca");
				System.out.print("Introduceti optiunea dumneavoastra: ");
				option1 = scanner.nextInt();
				switch (option1) {
				case 1: {
					int option1_1;
					do {
						System.out.println("1. Adaugare adresa");
						System.out.println("2. Afisare adrese");
						System.out.println("3. Stergere adresa");
						System.out.println("4. Ordonare adrese");
						System.out.println("5. Actualizare adresa");
						System.out.println("0. Return to main menu");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option1_1 = scanner.nextInt();
						switch (option1_1) {
						case 1: {
							addressService.addAddress(address);
							break;
						}
						case 2: {
							System.out.println(addressService.showAllAddresses());
							break;
						}
						case 3: {
							int option1_3;
							do {
								System.out.println("1. Stergeti o anumita adresa");
								System.out.println("2. Stergeti toate adresele");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option1_3 = scanner.nextInt();
								switch (option1_3) {
								case 1: {
									addressService.deleteAddress(address);
									break;
								}
								case 2: {
									addressService.deleteAllAddresses();
									break;
								}
								default: {
									System.err.println("Optiunea introdusa este inexistenta!");
									break;

								}
								}
							} while (option1_3 != 0);
							break;
						}
						case 4: {
							int option1_4;
							do {
								System.out.println("1. Order address by no");
								System.out.println("2. Order address by county");
								System.out.println("3. Order address by city");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option1_4 = scanner.nextInt();
								switch (option1_4) {
								case 1: {
									System.out.println("1. Ascendent");
									System.out.println("2. Descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option1_4_1 = scanner.nextInt();
									if (option1_4_1 == 1)
										System.out.println(addressService.orderAddressesByNoAsc());
									if (option1_4_1 == 2)
										System.out.println(addressService.orderAddressesByNoDesc());
									break;
								}
								case 2: {
									System.out.println("1. Ascendent");
									System.out.println("2. Descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option1_4_2 = scanner.nextInt();
									if (option1_4_2 == 1)
										System.out.println(addressService.orderAddressesByCountyAsc());
									if (option1_4_2 == 2)
										System.out.println(addressService.orderAddressesByCountyDesc());
									break;
								}
								case 3: {
									System.out.println("1. Ascendent");
									System.out.println("2. Descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option1_4_3 = scanner.nextInt();
									if (option1_4_3 == 1)
										System.out.println(addressService.orderAddressesByCityAsc());
									if (option1_4_3 == 2)
										System.out.println(addressService.orderAddressesByCityDesc());
									break;
								}
								default:
									System.err.println("Optiunea introdusa este inexistenta!");
									break;
								}
							} while (option1_4 != 0);
							break;
						}
						case 5: {
							addressService.updateAddress(address);
							break;
						}
						default:
							System.err.println("Optiunea introdusa este inexistenta!");
							break;
						}
					} while (option1_1 != 0);
					break;
				}
				case 2: {
					int option2_1;
					do {
						System.out.println("1. Adaugare client");
						System.out.println("2. Afisare clienti");
						System.out.println("3. Stergere client");
						System.out.println("4. Ordonare clienti");
						System.out.println("5. Actualizare date client");
						System.out.println("6. Cautare client");
						System.out.println("0. Return to main menu");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option2_1 = scanner.nextInt();
						switch (option2_1) {
						case 1: {
							clientService.addClient(client);
							break;
						}
						case 2: {
							System.out.println(clientService.showAllClients());
							break;
						}
						case 3: {
							int option2_1_3;
							do {
								System.out.println("1. Stergeti un anumit client");
								System.out.println("2. Stergeti toti clientii");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_3 = scanner.nextInt();
								switch (option2_1_3) {
								case 1: {
									clientService.deleteClient();
									break;
								}
								case 2: {
									clientService.deleteAllClients();
									break;
								}
								default:
									System.err.println("Optiunea introdusa este inexistenta!");
								}
							} while (option2_1_3 != 0);
							break;
						}
						case 4: {
							int option2_1_4;
							do {
								System.out.println("1. Order clients by no");
								System.out.println("2. Order clients by id");
								System.out.println("3. Order clients by first name");
								System.out.println("4. Order clients by last name");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_4 = scanner.nextInt();
								switch (option2_1_4) {
								case 1: {
									System.out.println("1. For ascendent");
									System.out.println("2. For descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option5_1 = scanner.nextInt();
									if (option5_1 == 1)
										System.out.println(clientService.orderClientsByNoAsc());
									if (option5_1 == 2)
										System.out.println(clientService.orderClientsByNoDesc());
									break;
								}
								case 2: {
									System.out.println("1. Ascendent");
									System.out.println("2. Descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option5_2 = scanner.nextInt();
									if (option5_2 == 1)
										System.out.println(clientService.orderClientsByIdAsc());
									if (option5_2 == 2)
										System.out.println(clientService.orderClientsByIdDesc());
									break;
								}
								case 3: {
									System.out.println("1. Ascendent");
									System.out.println("2. Descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option5_3 = scanner.nextInt();
									if (option5_3 == 1)
										System.out.println(clientService.orderClientsByFirstNameAsc());
									if (option5_3 == 2)
										System.out.println(clientService.orderClientsByFirstNameDesc());
									break;
								}
								case 4: {
									System.out.println("1. Ascendent");
									System.out.println("2. Descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option5_4 = scanner.nextInt();
									if (option5_4 == 1)
										System.out.println(clientService.orderClientsByLastNameAsc());
									if (option5_4 == 2)
										System.out.println(clientService.orderClientsByLastNameDesc());
									break;
								}
								default:
									System.err.println("Optiunea introdusa este inexistenta!");
									break;
								}
							} while (option2_1_4 != 0);
							break;
						}
						case 5: {
							int option2_1_5;
							do {
								System.out.println("1. Update client email");
								System.out.println("2. Update client phone");
								System.out.println("3. Update client first name");
								System.out.println("4. Update client last name");
								System.out.println("5. Update client address");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_5 = scanner.nextInt();
								switch (option2_1_5) {
								case 1: {
									clientService.updateClientEmail(client);
									break;
								}
								case 2: {
									clientService.updateClientPhoneNumber(client);
									break;
								}
								case 3: {
									clientService.updateClientFirstName(client);
									break;
								}
								case 4: {
									clientService.updateClientLastName(client);
									break;
								}
								default:
									System.err.println("Optiunea introdusa este inexistenta!");
								}
							} while (option2_1_5 != 0);
							break;
						}
						case 6: {
							int option2_1_6;
							do {
								System.out.println("1. Find by first name");
								System.out.println("2. Find by CNP");
								System.out.println("3. Find by ID");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_6 = scanner.nextInt();
								switch (option2_1_6) {
								case 1: {
									System.out.print("Introduceti numele clientului cautat: ");
									String firstName = scanner.next();
									System.out.println(clientService.findClientByFirstName(firstName));
									break;
								}
								case 2: {
									System.out.print("Introduceti CNP-ul clientului cautat: ");
									int cnp = scanner.nextInt();
									System.out.println(clientService.findClientByCnp(cnp));
									break;
								}
								case 3: {
									System.out.print("Introduceti ID-ul clientului cautat: ");
									String id = scanner.next();
									System.out.println(clientService.findClientById(id));
									break;
								}
								default:
									System.err.println("Optiunea introdusa este inexistenta!");
								}
							} while (option2_1_6 != 0);
							break;
						}
						default:
							System.err.println("Optiunea introdusa este inexistenta!");
							break;
						}
					} while (option2_1 != 0);
					break;
				}
				case 3: {
					int option3_1;
					System.out.println("1. Agentie bancara");
					System.out.println("2. Angajati");
					System.out.println("0. Return to main menu");
					System.out.print("Introduceti optiunea dumneavoastra: ");
					option3_1 = scanner.nextInt();
					switch (option3_1) {
					case 1: {
						int option3_1_1;
						System.out.println("1. Adaugare agentie noua");
						System.out.println("2. Afisare agentii");
						System.out.println("3. Stergere agentie");
						System.out.println("4. Ordonare agentii");
						System.out.println("5. Actualizare date agentii");
						System.out.println("6. Cautare agentii");
						System.out.println("0. Return to main menu");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option3_1_1 = scanner.nextInt();
						switch (option3_1_1) {
						case 1: {
							bankAgencyService.addBankAgency(bankAgency);
							break;
						}
						case 2: {
							System.out.println(bankAgencyService.showAllBankAgency());
							break;
						}
						case 3: {
							int option3_1_1_3;
							do {
								System.out.println("1. Stergeti o anumita agentie");
								System.out.println("2. Stergeti toate agentiile");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option3_1_1_3 = scanner.nextInt();
								switch (option3_1_1_3) {
								case 1: {
									addressService.deleteAddress(address);
									break;
								}
								case 2: {
									addressService.deleteAllAddresses();
									break;
								}
								default:
									System.err.print("Optiunea introdusa este inexistenta!");
									break;
								}
							} while (option3_1_1_3 != 0);
							break;
						}
						case 4: {
							int option3_1_1_4;
							do {
								System.out.println("1. Order bank agency by no");
								System.out.println("2. Order bank agency by id");
								System.out.println("3. Order bank agency by operating hours");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option3_1_1_4 = scanner.nextInt();
								switch (option3_1_1_4) {
								case 1: {
									System.out.println("1. For ascendent");
									System.out.println("2. For descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option3_1_1_4_1 = scanner.nextInt();
									if (option3_1_1_4_1 == 1)
										System.out.println(bankAgencyService.orderBankByNoAsc());
									if (option3_1_1_4_1 == 2)
										System.out.println(bankAgencyService.orderBankByNoDesc());
									break;
								}
								case 2: {
									System.out.println("1. For ascendent");
									System.out.println("2. For descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option3_1_1_4_2 = scanner.nextInt();
									if (option3_1_1_4_2 == 1)
										System.out.println(bankAgencyService.orderBankByIdAsc());
									if (option3_1_1_4_2 == 2)
										System.out.println(bankAgencyService.orderBankByIdDesc());
									break;
								}
								case 3: {
									System.out.println("1. For ascendent");
									System.out.println("2. For descendent");
									System.out.print("Introduceti optiunea dumneavoastra: ");
									int option3_1_1_4_3 = scanner.nextInt();
									if (option3_1_1_4_3 == 1)
										System.out.println(bankAgencyService.orderBankByNoAsc());
									if (option3_1_1_4_3 == 2)
										System.out.println(bankAgencyService.orderBankByNoDesc());
									break;
								}
								default:
									System.err.println("Optiunea introdusa este inexistenta!");
									break;
								}
							} while (option3_1_1_4 != 0);
							break;
						}
						case 5: {
							bankAgencyService.updateBankAgency(bankAgency);
							break;
						}
						case 6: {
							int option3_1_1_6;
							do {
								System.out.println("1. Find by no");
								System.out.println("2. Find by city");
								System.out.println("0. Return to main menu");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option3_1_1_6 = scanner.nextInt();
								switch (option3_1_1_6) {
								case 1: {
									int no;
									System.out.print("Introduceti numarul agentiei pe care o cautati: ");
									no = scanner.nextInt();
									System.out.println(bankAgencyService.findBankAgencyByNo(no));
									break;
								}
								case 2: {
									String city;
									System.out.print("Introduceti orasul in care doriti sa cautati: ");
									city = scanner.next();
									System.out.println(bankAgencyService.findBankAgencyByCity(city));
									break;
								}
								default:
									System.err.print("Optiunea introdusa este inexistenta!");
									break;
								}
							} while (option3_1_1_6 != 0);
							break;
						}
						default:
							System.err.println("Optiunea introdusa este inexistenta!");
							break;
						}
						break;
					}
					case 2: {
						break;
					}
					default:
						System.err.println("Optiunea introdusa este inexistenta!");
						break;
					}
					break;
				}

				default:
					System.err.println("Optiunea introdusa este inexistenta!");
					break;
				}
			} while (option1 != 0);
			break;
		}

		case 2: {
			clientService.clientLogin();
			System.out.println("Ai reusit sa te autentifici ca si client!");
			hello.hello();
			break;
		}
		default:
			System.err.println("Optiunea introdusa este inexistenta!");
			break;
		}

	}
}
